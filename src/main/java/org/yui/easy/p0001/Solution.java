package org.yui.easy.p0001;

import java.util.Arrays;

/**
 * @program: leet-code
 * @description: 1.整数求和
 * @author: yui
 * @create: 2019-12-30 17:20
 **/
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        int length = nums.length;
        int sum;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }

}
