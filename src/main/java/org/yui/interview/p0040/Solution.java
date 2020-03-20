package org.yui.interview.p0040;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 面试题40. 最小的k个数
 * @author: YuI
 * @create: 2020/3/20 13:00
 **/
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 排序
        Arrays.sort(arr);

        // 选择前k个数
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.getLeastNumbers(new int[]{3, 2, 1}, 2);

        Arrays.stream(result).forEach(System.out::println);
    }
}
