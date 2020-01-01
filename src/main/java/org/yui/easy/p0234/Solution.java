package org.yui.easy.p0234;

import org.yui.structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @program: leetcode
 * @description: 234.回文链表
 * @author: yui
 * @create: 2020-01-02 02:43
 **/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        ListNode pre = null;
        ListNode last;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;

            last = slowNode.next;
            slowNode.next = pre;
            pre = slowNode;
            slowNode = last;
        }

        if (fastNode != null) {
            slowNode = slowNode.next;
        }

        while (slowNode != null && pre != null) {
            if (slowNode.val != pre.val) {
                return false;
            }
            slowNode = slowNode.next;
            pre = pre.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 2, 1});
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(head);

        System.out.println(result);
    }
}
