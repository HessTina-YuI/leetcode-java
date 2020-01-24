package org.yui.medium.p0092;

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
 * @description: 92.反转链表II
 * @author: YuI
 * @create: 2020-01-02 01:28
 **/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        if (pre != null) {
            pre.next = null;
        }

        ListNode beforeReverse = pre;
        ListNode retailReverse = cur;
        ListNode last;
        for (int i = m; i <= n; i++) {
            last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
        }

        if (beforeReverse == null) {
            head = pre;
        } else {
            beforeReverse.next = pre;
        }
        retailReverse.next = cur;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        ListNode result = solution.reverseBetween(head, 2, 4);

        System.out.println(result.printNode());
    }
}
