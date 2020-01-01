package org.yui.easy.p0021;

import org.yui.structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @program: leet-code
 * @description: 21.合并两个有序链表
 * @author: yui
 * @create: 2019-12-30 20:22
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode lTemp1 = l1;
        ListNode lTemp2 = l2;

        ListNode res = new ListNode(-1);
        ListNode p = res;

        while (lTemp1 != null || lTemp2 != null) {
            if (lTemp1 == null) {
                p = new ListNode(lTemp2.val);
                p = p.next;
                lTemp2 = lTemp2.next;
            } else if (lTemp2 == null) {
                p.next = new ListNode(lTemp1.val);
                p = p.next;
                lTemp1 = lTemp1.next;
            } else if (lTemp1.val > lTemp2.val) {
                p.next = new ListNode(lTemp2.val);
                p = p.next;
                lTemp2 = lTemp2.next;
            } else {
                // lTemp1.val <= lTemp2.val
                p.next = new ListNode(lTemp1.val);
                p = p.next;
                lTemp1 = lTemp1.next;
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});

        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(l1, l2);

        System.out.println(result);
    }
}
