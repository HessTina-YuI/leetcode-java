package org.yui.medium.p0215;

import java.util.*;

/**
 * @program: leetcode
 * @description: 215.数组中的第K个最大元素
 * @author: YuI
 * @create: 2020-01-02 19:07
 **/
public class Solution {

    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) {
            return -1;
        }

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        if (queue.size() == 0) {
            return -1;
        }
        return queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) {
            return -1;
        }

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2);

        System.out.println(result);
    }
}
