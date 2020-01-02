package org.yui.easy.p0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: leet-code
 * @description: 20.有效的括号
 * @author: yui
 * @create: 2019-12-30 20:07
 **/
public class Solution {
    public boolean isValid1(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
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

    public boolean isValid2(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> maps = new HashMap<>(3);
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');
        for (char c : chars) {
            if (!maps.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || !maps.get(c).equals(stack.pop())) {
                return false;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isValid2("{[()()()]}");

        System.out.println(result);
    }
}
