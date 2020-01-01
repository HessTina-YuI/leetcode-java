package org.yui.medium.p0024;

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
 * @description: 24. 两两交换链表中的节点
 * @author: yui
 * @create: 2020-01-01 18:49
 **/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        head = pre;

        ListNode last;
        ListNode cur = pre.next;

        while (cur != null && cur.next != null) {
            last = cur.next;
            cur.next = last.next;
            last.next = cur;
            pre.next = last;

            pre = pre.next.next;
            cur = pre.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6});
        Solution solution = new Solution();
        ListNode result = solution.swapPairs(head);

        System.out.println(result);
    }
}
