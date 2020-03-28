package org.yui.medium.p0820;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0820
 * @description: 820. 单词的压缩编码
 * @author: YuI
 * @create: 2020/3/28 23:11
 **/
public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> setWords = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                setWords.remove(word.substring(i));
            }
        }

        int account = 0;
        for (String word : setWords) {
            account += word.length() + 1;
        }

        return account;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.minimumLengthEncoding(new String[]{"time", "me", "bell"});

        System.out.println(result);
    }
}
