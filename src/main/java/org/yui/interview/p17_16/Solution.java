package org.yui.interview.p17_16;

/**
 * @program: leetcode
 * @package: org.yui.interview.p17_16
 * @description: 面试题 17.16. 按摩师
 * @author: YuI
 * @create: 2020/3/24 21:55
 **/
public class Solution {

    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i]：区间 [0, i] 里接受预约请求的最大时长
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // 今天在选与不选中，选择一个最优的
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3});

        System.out.println(result);
    }
}
