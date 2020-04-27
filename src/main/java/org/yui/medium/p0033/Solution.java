package org.yui.medium.p0033;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0033
 * @description: 33. 搜索旋转排序数组
 * @author: YuI
 * @create: 2020/4/27 13:09
 **/
public class Solution {

    public int search(int[] nums, int target) {
        return searchRecursive(nums, target, 0, nums.length - 1);
    }

    private int searchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[left] == target) {
            return left;
        }
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[right] == target) {
            return right;
        }

        if (nums[left] < nums[mid]) {
            if (nums[left] < target && target < nums[mid]) {
                return searchRecursive(nums, target, left + 1, mid - 1);
            } else {
                return searchRecursive(nums, target, mid + 1, right - 1);
            }
        } else {
            if (nums[mid] < target && target < nums[right]) {
                return searchRecursive(nums, target, mid + 1, right - 1);
            } else {
                return searchRecursive(nums, target, left + 1, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);

        System.out.println(result);
    }

}
