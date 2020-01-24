package org.yui.easy.p0014;

/**
 * @program: leet-code
 * @description: 14.最长公共前缀
 * @author: YuI
 * @create: 2019-12-30 19:43
 **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;

        // 最小长度
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        for (int i = 0; i < minLength; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLength);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});

        System.out.println(result);
    }
}
