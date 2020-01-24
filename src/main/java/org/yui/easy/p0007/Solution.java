package org.yui.easy.p0007;

/**
 * @program: leet-code
 * @description: 7.整数反转
 * @author: YuI
 * @create: 2019-12-30 17:30
 **/
public class Solution {

    public int reverse(int x) {
        long res = 0;

        for (; x != 0; x /= 10) {
            res = res * 10 + x % 10;
        }

        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.reverse(-15);

        System.out.println(result);
    }

}
