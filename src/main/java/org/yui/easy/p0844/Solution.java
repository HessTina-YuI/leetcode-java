package org.yui.easy.p0844;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 844.比较含退格的字符串
 * @author: YuI
 * @create: 2020-01-02 19:24
 **/
public class Solution {
    public boolean backspaceCompare1(String S, String T) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (stack.size() != 0) {
                stack.pop();
            }
        }
        S = String.valueOf(stack);

        stack.clear();
        for (char c : T.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (stack.size() != 0) {
                stack.pop();
            }
        }
        T = String.valueOf(stack);

        return S.equals(T);
    }

    public boolean backspaceCompare2(String S, String T) {
        StringBuilder sBuilder = new StringBuilder(S.length());

        int backCount = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '#') {
                if (backCount > 0) {
                    backCount--;
                } else {
                    sBuilder.append(S.charAt(i));
                }
            } else {
                backCount++;
            }
        }

        backCount = 0;
        StringBuilder tBuilder = new StringBuilder(T.length());
        for (int i = T.length() - 1; i >= 0; i--) {
            if (T.charAt(i) != '#') {
                if (backCount > 0) {
                    backCount--;
                } else {
                    tBuilder.append(T.charAt(i));
                }
            } else {
                backCount++;
            }
        }

        return sBuilder.toString().equals(tBuilder.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.backspaceCompare2("y#fo##f", "y#f#o##f");

        System.out.println(result);
    }
}
