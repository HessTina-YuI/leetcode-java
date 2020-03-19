package org.yui.easy.p0409;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 409. 最长回文串
 * @author: YuI
 * @create: 2020/3/19 20:38
 **/
public class Solution {
    public int longestPalindrome1(String s) {
        int sum = 0;

        // ASCII个数有128个
        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        for (int v : letters) {
            sum += v / 2 * 2;
            if (v % 2 == 1 && sum % 2 == 0) {
                sum++;
            }
        }

        return sum;
    }

    public int longestPalindrome2(String s) {
        int sum = 0;

        // 大小写字母个数
        int[] letters = new int[52];
        for (char c : s.toCharArray()) {
            letters[Character.isUpperCase(c) ? c - 'A' : c - 'a' + 26]++;
        }

        for (int v : letters) {
            sum += v / 2 * 2;
            if (v % 2 == 1 && sum % 2 == 0) {
                sum++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.longestPalindrome1("abccccdd");

        System.out.println(result);
    }
}
