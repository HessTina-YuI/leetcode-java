package org.yui.easy.p0066;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 66. 加一
 * @author: yui
 * @create: 2020-01-21 15:21
 **/
public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;

            if (digits[i] != 0) {
                return digits;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.plusOne(new int[]{1, 2, 3});

        Arrays.stream(result).forEach(System.out::println);
    }
}
