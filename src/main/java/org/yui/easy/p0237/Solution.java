package org.yui.easy.p0237;

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
 * @description: 237.删除链表中的节点
 * @author: YuI
 * @create: 2020-01-02 03:34
 **/
public class Solution {
    public void deleteNode(ListNode node) {
        while (node != null && node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{4,5,1,9});
        Solution solution = new Solution();
        solution.deleteNode(head.next);

        System.out.println(head.printNode());
    }
}
