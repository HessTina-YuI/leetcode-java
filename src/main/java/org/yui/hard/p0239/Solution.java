package org.yui.hard.p0239;

import java.util.*;

/**
 * @program: leetcode
 * @description: 239.滑动窗口最大值
 * @author: yui
 * @create: 2020-01-03 22:39
 **/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) {
            return new int[]{};
        }

        Deque<Integer> window = new ArrayDeque<>(k);
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && window.size() != 0 && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            while (window.size() != 0 && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }
            window.addLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[window.size() != 0 ? window.peekFirst() : 0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
