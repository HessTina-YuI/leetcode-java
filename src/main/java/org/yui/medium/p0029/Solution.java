package org.yui.medium.p0029;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0029
 * @description: 29. 两数相除
 * @author: YuI
 * @create: 2020/4/14 16:32
 **/
public class Solution {

    public int divide(int dividend, int divisor) {
        long result = (long) dividend / (long) divisor;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.divide(-2147483648, -1);

        System.out.println(result);
    }

}
