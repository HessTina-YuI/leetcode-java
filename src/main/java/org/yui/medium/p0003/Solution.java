package org.yui.medium.p0003;

/**
 * @program: leetcode
 * @description: 3.无重复字符的最长子串
 * @author: YuI
 * @create: 2019-12-31 15:07
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = new char[s.length()];
        chars[0] = s.charAt(0);
        int head = 0;
        int diffLength = 1;
        int maxLength = diffLength;

        for (int i = 1; i < s.length(); i++) {
            int temp = containsCharPosition(chars, s.charAt(i), head, i);
            if (temp == -1) {
                // 没有包含
                diffLength++;
            } else {
                // 包含
                if (maxLength < diffLength) {
                    maxLength = diffLength;
                }
                diffLength = i - temp;
                head = temp;
            }
            chars[i] = s.charAt(i);
        }

        if (maxLength < diffLength) {
            maxLength = diffLength;
        }

        return maxLength;
    }

    public int containsCharPosition(char[] chars, char c, int head, int retail) {
        for (int i = retail; i >= head ; i--) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring("cdd");

        System.out.println(result);
    }
}
