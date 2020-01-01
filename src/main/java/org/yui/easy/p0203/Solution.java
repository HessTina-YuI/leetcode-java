package org.yui.easy.p0203;

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
 * @description: 203.移除链表元素
 * @author: yui
 * @create: 2020-01-02 02:33
 **/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode step = new ListNode(-1);
        step.next = head;
        head = step;

        ListNode pre = step;
        step = step.next;
        while (step != null) {
            if (step.val == val) {
                pre.next = step.next;
            } else {
                pre = pre.next;
            }
            step = step.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1});
        Solution solution = new Solution();
        ListNode result = solution.removeElements(head, 1);

        System.out.println(result == null ? null : result.printNode());
    }
}
