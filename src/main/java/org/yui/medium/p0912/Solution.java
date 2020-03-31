package org.yui.medium.p0912;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0912
 * @description: 912. 排序数组
 * @author: YuI
 * @create: 2020/3/31 21:40
 **/
public class Solution {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }


    private int partition(int[] nums, int left, int right) {
        int l = left;
        int r = right - 1;
        while (true) {
            while (l <= r && nums[l] <= nums[right]) {
                l++;
            }
            while (l <= r && nums[r] >= nums[right]) {
                r--;
            }
            if (l > r) {
                break;
            }
            swap(nums, l, r);
            l++;
            r--;
        }

        swap(nums, l, right);
        return l;
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.sortArray(new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1});

        Arrays.stream(result).forEach(System.out::println);
    }
}
