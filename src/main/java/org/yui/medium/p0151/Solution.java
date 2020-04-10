package org.yui.medium.p0151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0151
 * @description: 151. 翻转字符串里的单词
 * @author: YuI
 * @create: 2020/4/10 14:58
 **/
public class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.reverseWords("  hello world!  ");

        System.out.println(result);
    }
}
