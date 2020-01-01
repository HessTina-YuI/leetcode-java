package org.yui.medium.p0142;

import org.yui.structure.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 *
 * @program: leetcode
 * @description: 142.环形链表II
 * @author: yui
 * @create: 2020-01-01 19:56
 **/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fastNode = head.next.next;
        ListNode slowNode = head.next;

        while (fastNode != slowNode) {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        ListNode intersectNode = head;
        while (intersectNode != slowNode) {
            intersectNode = intersectNode.next;
            slowNode = slowNode.next;
        }

        return intersectNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{3, 2, 0, 4});
        head.next.next.next.next = head.next.next;
/*        ListNode head = new ListNode(new int[]{1, 2});
        head.next.next = head;*/

        Solution solution = new Solution();
        ListNode result = solution.detectCycle(head);

        System.out.println(result);
    }
}
