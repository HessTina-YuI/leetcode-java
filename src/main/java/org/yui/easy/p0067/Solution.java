package org.yui.easy.p0067;

/**
 * @program: leetcode
 * @description: 67. 二进制求和
 * @author: YuI
 * @create: 2020-01-21 15:41
 **/
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        String sLong, sShort;
        sLong = a.length() >= b.length() ? a : b;
        sShort = a.length() < b.length() ? a : b;
        int shortLength = sShort.length() - 1;

        int temp = 0;
        for (int i = sLong.length() - 1; i >= 0; i--) {
            if (shortLength >= 0) {
                temp += sLong.charAt(i) - '0' + sShort.charAt(shortLength) - '0';
                result.append(temp % 2);
                temp /= 2;
                shortLength--;
            } else {
                temp += sLong.charAt(i) - '0';
                result.append(temp % 2);
                temp /= 2;
            }
        }

        if (temp == 1) {
            result.append(1);
        }
        result.reverse();

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.addBinary("11", "1");

        System.out.println(result);
    }
}
