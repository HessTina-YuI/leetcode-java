package org.yui.medium.p0008;

/**
 * @program: leetcode
 * @description: 8.字符串转换整数 (atoi)
 * @author: yui
 * @create: 2020-01-03 00:47
 **/
public class Solution {
    public int myAtoi(String str) {
        boolean isNegative = false;
        boolean isAppear = false;
        long account = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (isAppear) {
                    break;
                }
                continue;
            }

            if (c == '-') {
                if (isAppear) {
                    break;
                }
                isAppear = true;
                isNegative = true;
                continue;
            }

            if (c == '+') {
                if (isAppear) {
                    break;
                }
                isAppear = true;
                continue;
            }

            if (c >= '0' && c <= '9') {
                isAppear = true;
                account = account * 10 + c - '0';

                if (account > Integer.MAX_VALUE) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                continue;
            }

            break;
        }

        if (isNegative) {
            account = -account;
        }

        return (int) account;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.myAtoi("9223372036854775808");

        System.out.println(result);
    }
}
