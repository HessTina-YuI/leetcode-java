package org.yui.medium.p0031;

import java.util.Arrays;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0031
 * @description: 31. 下一个排列
 * @author: YuI
 * @create: 2020/4/16 17:32
 **/
public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
/*            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }*/
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            swap(nums, i, j - 1);
        }

        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        solution.nextPermutation(result);

        Arrays.stream(result).forEach(a -> System.out.print(a + " "));
    }
}
