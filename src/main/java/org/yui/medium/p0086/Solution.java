package org.yui.medium.p0086;

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
 * @description: 86. 分隔链表
 * @author: YuI
 * @create: 2020-01-02 01:03
 **/
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessNode = new ListNode(-1);
        ListNode largeNode = new ListNode(-1);

        ListNode headStep = head;
        ListNode lessStep = lessNode;
        ListNode largeStep = largeNode;
        while (headStep != null) {
            if (headStep.val < x) {
                lessStep.next = new ListNode(headStep.val);
                lessStep = lessStep.next;
            } else {
                largeStep.next = new ListNode(headStep.val);
                largeStep = largeStep.next;
            }
            headStep = headStep.next;
        }

        lessStep.next = largeNode.next;

        return lessNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        Solution solution = new Solution();
        ListNode result = solution.partition(head, 3);

        System.out.println(result.printNode());
    }
}
