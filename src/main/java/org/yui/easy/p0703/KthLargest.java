package org.yui.easy.p0703;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 *
 * @program: leetcode
 * @description: 703.数据流中的第K大元素
 * @author: YuI
 * @create: 2020-01-03 21:38
 **/
public class KthLargest {
    int k;
    Queue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}
