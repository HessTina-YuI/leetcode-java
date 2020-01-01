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

    @Override
    public String toString() {
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
