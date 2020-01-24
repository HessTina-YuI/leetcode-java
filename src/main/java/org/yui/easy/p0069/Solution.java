package org.yui.easy.p0069;

/**
 * @program: leetcode
 * @description: 69. x 的平方根
 * @author: YuI
 * @create: 2020-01-24 15:17
 **/
public class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long mid;
        while (left < right) {
            mid = (left + right + 1) >> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.mySqrt(4);

        System.out.println(result);
    }
}
