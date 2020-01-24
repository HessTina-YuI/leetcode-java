package org.yui.hard.p0025;

import org.yui.structure.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @program: leetcode
 * @description: 25.K个一组翻转链表
 * @author: YuI
 * @create: 2020-01-02 15:30
 **/
public class Solution {
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = new ListNode(-1);
        ListNode pre;
        cur.next = head;
        head = cur;
        cur = head.next;
        pre = head;

        int n = 0;
        ListNode temp;
        while (cur != null) {
            if (n == k) {
                while (!stack.empty()) {
                    pre.next = stack.pop();
                    pre = pre.next;
                }
                n = 0;
            } else {
                temp = cur;
                cur = cur.next;
                temp.next = null;
                stack.push(temp);
                n++;
            }
        }

        if (stack.size() == k) {
            while (!stack.empty()) {
                pre.next = stack.pop();
                pre = pre.next;
            }
        } else {
            while (!stack.empty()) {
                pre.next = stack.remove(0);
                pre = pre.next;
            }
        }

        return head.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode cur = head;

        // 剩余的结点数不够反转
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }

        cur = head;
        ListNode pre = null;
        ListNode last;
        for (int i = 0; i < k; i++) {
            last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
        }
        head.next = reverseKGroup2(cur, k);

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        ListNode result = solution.reverseKGroup2(head, 3);

        System.out.println(result.printNode());
    }
}
