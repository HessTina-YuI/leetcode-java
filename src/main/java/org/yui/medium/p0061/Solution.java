package org.yui.medium.p0061;

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
 * @description: 61.旋转链表
 * @author: YuI
 * @create: 2020-01-01 23:11
 **/
public class Solution {
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode preRotateNode = head;
        ListNode lastRotateNode = head;

        for (int i = 0; i < k; i++) {
            lastRotateNode = lastRotateNode.next;
            if (lastRotateNode == null) {
                lastRotateNode = head;
            }
        }

        while (lastRotateNode.next != null) {
            preRotateNode = preRotateNode.next;
            lastRotateNode = lastRotateNode.next;
        }

        lastRotateNode.next = head;
        head = preRotateNode.next;
        preRotateNode.next = null;

        return head;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode lastNode = head;
        while (lastNode.next != null) {
            length++;
            lastNode = lastNode.next;
        }
        lastNode.next = head;

        int step = length - k % length - 1;
        for (int i = 0; i < step; i++) {
            head = head.next;
        }

        ListNode temp = head;
        head = temp.next;
        temp.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2});
        Solution solution = new Solution();
        ListNode result = solution.rotateRight2(head, 1);

        System.out.println(result.printNode());
    }
}
