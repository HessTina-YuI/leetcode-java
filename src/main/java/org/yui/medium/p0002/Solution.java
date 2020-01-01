package org.yui.medium.p0002;

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
 * @description: 2.两数相加
 * @author: yui
 * @create: 2019-12-31 14:37
 **/
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lTemp1 = l1;
        ListNode lTemp2 = l2;

        ListNode res = new ListNode(-1);
        ListNode resTemp = res;
        int addNum = 0;
        int sumTemp;
        int lVal1;
        int lVal2;

        while (lTemp1 != null || lTemp2 != null) {
            lVal1 = (lTemp1 != null) ? lTemp1.val : 0;
            lVal2 = (lTemp2 != null) ? lTemp2.val : 0;
            sumTemp = lVal1 + lVal2 + addNum;
            resTemp.next = new ListNode(sumTemp % 10);
            resTemp = resTemp.next;
            addNum = sumTemp / 10;

            if (lTemp1!= null) {
                lTemp1 = lTemp1.next;
            }
            if (lTemp2 !=null) {
                lTemp2 = lTemp2.next;
            }
        }

        if (addNum != 0) {
            resTemp.next = new ListNode(addNum);
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{2,4,3});
        ListNode l2 = new ListNode(new int[]{5,6,4});

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println(result);
    }
}
