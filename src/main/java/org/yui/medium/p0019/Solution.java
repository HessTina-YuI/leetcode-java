package org.yui.medium.p0019;

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
 * @description: 19.删除链表的倒数第N个节点
 * @author: yui
 * @create: 2020-01-01 22:48
 **/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode retailNode = head;
        ListNode preDeleteNode = head;

        for (int i = 0; i < n; i++) {
            retailNode = retailNode.next;
        }

        if (retailNode == null) {
            return head.next;
        }

        while (retailNode.next != null) {
            retailNode = retailNode.next;
            preDeleteNode = preDeleteNode.next;
        }

        preDeleteNode.next = preDeleteNode.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        ListNode result = solution.removeNthFromEnd(head, 2);

        System.out.println(result == null ? null : result.printNode());
    }
}
