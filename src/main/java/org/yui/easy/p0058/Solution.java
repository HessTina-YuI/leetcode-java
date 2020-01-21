package org.yui.easy.p0058;

/**
 * @program: leetcode
 * @description: 58.最后一个单词的长度
 * @author: yui
 * @create: 2020-01-21 15:04
 **/
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }

        int length = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                length = 0;
            } else {
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lengthOfLastWord("Hello World");

        System.out.println(result);
    }
}
