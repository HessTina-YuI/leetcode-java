package org.yui.easy.p0013;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet-code
 * @description: 13.罗马数字转整数
 * @author: YuI
 * @create: 2019-12-30 18:25
 **/
public class Solution {

    public int romanToInt1(String s) {
        char[] chars = s.toCharArray();

        int sum = 0;
        int next;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I':
                    next = i + 1;
                    if (next < chars.length && (chars[next] == 'V' || chars[next] == 'X')) {
                        sum -= 1;
                    } else {
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    next = i + 1;
                    if (next < chars.length && (chars[next] == 'L' || chars[next] == 'C')) {
                        sum -= 10;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    next = i + 1;
                    if (next < chars.length && (chars[next] == 'D' || chars[next] == 'M')) {
                        sum -= 100;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    break;
            }

        }
        return sum;
    }

    public int romanToInt2(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<Character, Integer>(10);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = map.get(chars[chars.length - 1]);
        for (int i = chars.length - 2; i >= 0; i--) {
            if (map.get(chars[i]) < map.get(chars[i + 1])) {
                sum -= map.get(chars[i]);
            } else {
                sum += map.get(chars[i]);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.romanToInt2("MCMXCIV");

        System.out.println(result);
    }

}
