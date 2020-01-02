package org.yui.medium.p0143;

import org.yui.structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @program: leetcode
 * @description: 143.重排链表
 * @author: yui
 * @create: 2020-01-02 16:48
 **/
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode cur = head.next;
        ListNode temp;
        Deque<ListNode> deque = new ArrayDeque<>(1000);
        while (cur != null) {
            temp = cur;
            cur = cur.next;
            temp.next = null;
            deque.add(temp);
        }

        cur = head;
        boolean popRetail = true;
        while (!deque.isEmpty()) {
            if (popRetail) {
                cur.next = deque.pollLast();
                popRetail = false;
            } else {
                cur.next = deque.pollFirst();
                popRetail = true;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        solution.reorderList(head);

        System.out.println(head.printNode());
    }
}
