package org.yui.medium.p0016;

import java.util.Arrays;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0016
 * @description: 16. 最接近的三数之和
 * @author: YuI
 * @create: 2020/4/16 16:39
 **/
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(ans - target) > Math.abs(sum - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1);

        System.out.println(result);
    }

}
