package org.yui.medium.p0365;

/**
 * @program: leetcode
 * @description: 365. 水壶问题
 * @author: YuI
 * @create: 2020/3/21 0:11
 **/
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        // 裴蜀定理
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % getGcd(x, y) == 0;
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
        boolean result = solution.canMeasureWater(2, 6, 5);

        System.out.println(result);
    }
}
