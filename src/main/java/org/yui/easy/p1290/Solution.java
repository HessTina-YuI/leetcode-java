package org.yui.easy.p1290;

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
 * @description: 1290.二进制链表转整数
 * @author: yui
 * @create: 2020-01-02 03:53
 **/
public class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode step = head;
        int sum = 0;
        while (step != null) {
            sum = sum * 2 + step.val;
            step = step.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
        Solution solution = new Solution();
        int result = solution.getDecimalValue(head);

        System.out.println(result);
    }
}
