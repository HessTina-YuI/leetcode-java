package org.yui.medium.p0012;

/**
 * @program: leetcode
 * @description: 12.整数转罗马数字
 * @author: yui
 * @create: 2020-01-03 02:26
 **/
public class Solution {
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        // 罗马数字
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // 阿拉伯数字
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int index = 0;
        while (num > 0) {
            int count = num / arab[index];
            while (count > 0) {
                stringBuilder.append(roman[index]);
                count--;
            }
            num %= arab[index];
            index++;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.intToRoman(3999);

        System.out.println(result);
    }
}
