package org.yui.medium.p0082;

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
 * @description: 82.删除排序链表中的重复元素II
 * @author: yui
 * @create: 2020-01-02 00:24
 **/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        ListNode pre = null;

        boolean isRepeat = false;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                isRepeat = true;
            } else {
                if (isRepeat) {
                    if (pre == null) {
                        head = head.next;
                    } else {
                        pre.next = node.next;
                    }
                    node = node.next;
                    isRepeat = false;
                } else {
                    pre = node;
                    node = node.next;
                }
            }
        }

        if (isRepeat) {
            if (pre == null) {
                head = null;
            } else {
                pre.next = null;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 1, 2, 2});
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(head);

        System.out.println(result == null ? null : result.printNode());
    }
}
