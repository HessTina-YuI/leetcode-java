package org.yui.medium.p1111;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: leetcode
 * @package: org.yui.medium.p1111
 * @description: 1111. 有效括号的嵌套深度
 * @author: YuI
 * @create: 2020/4/1 22:30
 **/
public class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        Stack<Character> stack = new Stack<>();
        int[] result = new int[seq.length()];

        int account = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                result[account++] = stack.size();
            } else if (c == ')') {
                result[account++] = stack.size();
                stack.pop();
            }
        }

        for (int i = 0; i < account; i++) {
            if (result[i] % 2 == 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.maxDepthAfterSplit("(()())");

        Arrays.stream(result).forEach(System.out::println);
    }

}
