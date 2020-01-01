package org.yui.structure;

/**
 * @program: leetcode
 * @description: 单链表的POJO类
 * @author: yui
 * @create: 2020-01-01 14:05
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] xs) {
        ListNode listNode = this;
        listNode.val = xs[0];

        for (int i = 1; i < xs.length; i++) {
            listNode.next = new ListNode(xs[i]);
            listNode = listNode.next;
        }
    }

    public String printNode() {
        ListNode listNode = this;

        StringBuilder stringBuilder = new StringBuilder();
        while (listNode != null) {
            stringBuilder.append(listNode.val);
            if (listNode.next != null) {
                stringBuilder.append("->");
            }
            listNode = listNode.next;
        }
        return stringBuilder.toString();
    }
}
