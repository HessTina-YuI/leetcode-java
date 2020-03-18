package org.yui.easy.p1160;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: leetcode
 * @description: 1160. 拼写单词
 * @author: YuI
 * @create: 2020/3/17 2:46
 **/
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        int[] letter = new int[26];
        for (char c : chars.toCharArray()) {
            letter[c - 'a']++;
        }

        for (String word : words) {
            boolean isSpell = true;
            int[] copy = letter.clone();
            for (char c : word.toCharArray()) {
                if (--copy[c - 'a'] < 0) {
                    isSpell = false;
                    break;
                }
            }
            if (isSpell) {
                sum += word.length();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr");

        System.out.println(result);
    }
}
