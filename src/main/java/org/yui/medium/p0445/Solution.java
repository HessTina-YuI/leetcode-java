package org.yui.medium.p0445;

import org.yui.structure.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @program: leetcode
 * @package: org.yui.medium.p0445
 * @description: 445. 两数相加 II
 * @author: YuI
 * @create: 2020/4/14 1:47
 **/
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int temp = 0;
        while (stack1.size() != 0 || stack2.size() != 0) {
            if (stack1.size() != 0) {
                temp += stack1.pop();
            }
            if (stack2.size() != 0) {
                temp += stack2.pop();
            }
            resultStack.push(temp % 10);
            temp /= 10;
        }
        if (temp != 0) {
            resultStack.push(temp);
        }

        ListNode resultNode = new ListNode(-1);
        ListNode pNode = resultNode;
        while (resultStack.size() != 0) {
            pNode.next = new ListNode(resultStack.pop());
            pNode = pNode.next;
        }

        return resultNode.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});

        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println(result == null ? null : result.printNode());
    }

}
