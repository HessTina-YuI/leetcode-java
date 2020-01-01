package org.yui.easy.p0876;

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
 * @description: 876.链表的中间结点
 * @author: yui
 * @create: 2020-01-02 03:45
 **/
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        ListNode result = solution.middleNode(head);

        System.out.println(result.printNode());
    }
}
