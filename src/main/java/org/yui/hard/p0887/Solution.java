package org.yui.hard.p0887;

/**
 * @program: leetcode
 * @package: org.yui.hard.p0887
 * @description: 887. 鸡蛋掉落
 * @author: YuI
 * @create: 2020/5/11 22:57
 **/
public class Solution {

    /**
     * @param K 鸡蛋个数
     * @param N 楼层高度
     * @return 最少丢鸡蛋的次数
     */
    public int superEggDrop1(int K, int N) {
        // dp[i] 代表 鸡蛋个数为 1，楼层为 i，即 dp(1, i)
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            dp[i] = i;
        }

        for (int k = 2; k <= K; ++k) {
            // dp2[i] 代表 鸡蛋个数为k，楼层为 i，即 dp(K, i)
            int[] dp2 = new int[N + 1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {
                // 寻找 dp2[n]
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < n && Math.max(dp[x - 1], dp2[n - 1]) > Math.max(dp[x], dp2[x])) {
                    x++;
                }

                // The final answer happens at this x.
                dp2[n] = 1 + Math.max(dp[x - 1], dp2[n - x]);
            }

            dp = dp2;
        }

        return dp[N];
    }

    /**
     * @param K 鸡蛋个数
     * @param N 楼层高度
     * @return 最少丢鸡蛋的次数
     */
    public int superEggDrop2(int K, int N) {
        // 楼层为1时，鸡蛋只用丢一次
        if (N == 1) {
            return 1;
        }

        int[][] dp = new int[N + 1][K + 1];
        // 楼层为1时，鸡蛋无论多少个都只丢一次
        for (int i = 1; i <= K; ++i) {
            dp[1][i] = 1;
        }

        int ans = -1;
        for (int i = 2; i <= N; ++i) {
            for (int j = 1; j <= K; ++j) {
                // 做到动态平衡
                // 在这一层 dp(k, n) 丢鸡蛋的次数，是本身的丢的1次
                // 加上 如果鸡蛋碎了以后， dp(k - 1, n - 1) 时丢鸡蛋个数
                // 加上 如果鸡蛋没碎， dp(k, n - 1) 时丢鸡蛋的个数
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            if (dp[i][K] >= N) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.superEggDrop2(2, 100);

        System.out.println(result);
    }

}
