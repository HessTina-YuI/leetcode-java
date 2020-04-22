package org.yui.interview.p08_11;

/**
 * @program: leetcode
 * @package: org.yui.interview.p08_11
 * @description: 面试题 08.11. 硬币
 * @author: YuI
 * @create: 2020/4/23 0:04
 **/
public class Solution {

    public int waysToChange(int n) {
        int mod = 1000000007;

        int[] type = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int value : type) {
            for (int j = value; j <= n; j++) {
                dp[j] += dp[j - value];
                if (dp[j] >= mod) {
                    dp[j] = dp[j] % mod;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.waysToChange(25);

        System.out.println(result);
    }
}
