package org.yui.easy.p0020;

import java.util.Stack;

/**
 * @program: leet-code
 * @description: 20.有效的括号
 * @author: yui
 * @create: 2019-12-30 20:07
 **/
public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        for (char c : chars) {
            switch (c) {
                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isValid("{[]}");

        System.out.println(result);
    }
}
