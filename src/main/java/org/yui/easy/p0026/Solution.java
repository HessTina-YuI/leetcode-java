package org.yui.easy.p0026;

/**
 * @program: leet-code
 * @description: 26.删除排序数组中的重复功能
 * @author: YuI
 * @create: 2019-12-30 21:14
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[sum] = nums[i];
                sum++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = solution.removeDuplicates(nums);

        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
}
