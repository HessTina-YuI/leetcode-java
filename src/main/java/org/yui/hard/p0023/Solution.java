package org.yui.hard.p0023;

import org.yui.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @program: leetcode
 * @description: 23.合并l个排序链表
 * @author: YuI
 * @create: 2020-01-02 04:02
 **/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode mergeNode = new ListNode(-1);
        ListNode step = mergeNode;

        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            step.next = new ListNode(temp.val);
            step = step.next;

            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }

        return mergeNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(new int[]{1, 4, 5});
        ListNode node2 = new ListNode(new int[]{1, 3, 4});
        ListNode node3 = new ListNode(new int[]{2, 6});

        Solution solution = new Solution();
        ListNode result = solution.mergeKLists(new ListNode[]{node1, node2, node3});

        System.out.println(result.printNode());
    }
}
