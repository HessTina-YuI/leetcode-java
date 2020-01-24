package org.yui.easy.p0028;

/**
 * @program: leet-code
 * @description: 28.实现strStr()
 * @author: YuI
 * @create: 2019-12-30 21:49
 **/
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.strStr("hello", "");

        System.out.println(result);
    }
}
