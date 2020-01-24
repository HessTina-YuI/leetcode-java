package org.yui.easy.p0160;

import org.yui.structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 *
 * @program: leetcode
 * @description: 160.相交链表
 * @author: YuI
 * @create: 2020-01-02 02:07
 **/
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode firstA = headA;
        ListNode firstB = headB;

        while (firstA != null || firstB != null) {
            if (firstA == null) {
                firstA = headB;
            }
            if (firstB == null) {
                firstB = headA;
            }

            if (firstA == firstB) {
                return firstA;
            }

            firstA = firstA.next;
            firstB = firstB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(new int[]{4, 1, 8, 4, 5});
        ListNode headB = new ListNode(new int[]{5, 0, 1});
        headB.next.next.next = headA.next.next;

        Solution solution = new Solution();
        ListNode result = solution.getIntersectionNode(headA, headB);

        System.out.println(result == null ? null : result.printNode());
    }
}
