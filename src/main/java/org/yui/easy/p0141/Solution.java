package org.yui.easy.p0141;

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
 * @description: 141. 环形链表
 * @author: yui
 * @create: 2020-01-01 19:39
 **/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while (fastNode != slowNode) {
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{3, 2, 0, 4});
        head.next.next.next.next = head.next.next;

        Solution solution = new Solution();
        boolean result = solution.hasCycle(head);

        System.out.println(result);
    }
}
