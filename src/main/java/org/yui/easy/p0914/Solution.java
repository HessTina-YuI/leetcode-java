package org.yui.easy.p0914;

/**
 * @program: leetcode
 * @package: org.yui.easy.p0914
 * @description: 914. 卡牌分组
 * @author: YuI
 * @create: 2020/3/27 2:21
 **/
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        int X = -1;
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                if (X == -1) {
                    X = count[i];
                } else {
                    X = getGcd(X, count[i]);
                }
            }
        }

        return X >= 2;
    }

    /***
     * 获取最大公约数
     * @param num1 第一个数
     * @param num2 第二个数
     * @return 最大公约数
     */
    public int getGcd(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        if (num2 == 0) {
            return num1;
        }
        if (num1 % 2 == 0 && num2 % 2 == 0) {
            return getGcd(num1 >> 1, num2 >> 1) << 1;
        } else if (num1 % 2 == 0) {
            return getGcd(num1 >> 1, num2);
        } else if (num2 % 2 == 0) {
            return getGcd(num1, num2 >> 1);
        } else {
            int min = Math.min(num1, num2);
            return getGcd(Math.abs(num1 - num2), min);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.hasGroupsSizeX(new int[]{0, 0, 0, 0, 0, 0});

        System.out.println(result);
    }
}
