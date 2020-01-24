package org.yui.easy.p0083;

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
 * @description: 83.删除排序链表中的重复元素
 * @author: YuI
 * @create: 2020-01-01 14:39
 **/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pre;

        while (cur != null) {
            int temp = cur.val;
            pre = cur;
            cur = cur.next;
            if (cur == null) {
                break;
            }
            if (temp == cur.val) {
                pre.next = cur.next;
                cur = pre;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 1, 2, 3, 3});
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(head);

        System.out.println(result.printNode());
    }
}
