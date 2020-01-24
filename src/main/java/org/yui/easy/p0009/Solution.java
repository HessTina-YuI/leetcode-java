package org.yui.easy.p0009;

/**
 * @program: leet-code
 * @description: 9.回文数
 * @author: YuI
 * @create: 2019-12-30 18:09
 **/
public class Solution {

    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;

        for (int i = 0; i <= length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(10);

        System.out.println(result);
    }

}
