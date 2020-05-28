package org.yui.medium.p0394;

import java.util.Stack;

/**
 * @program: leetcode
 * @package: org.yui.hard.p0345
 * @description: 394. 字符串解码
 * @author: YuI
 * @create: 2020/5/28 11:00
 **/
public class Solution {

    private static class Encode {
        /** 重复次数 */
        public int time = 0;
        /** 拼接字符串 */
        public StringBuilder str = new StringBuilder();
    }

    public String decodeString(String s) {
        Stack<Encode> stack = new Stack<>();

        Encode encode = new Encode();
        encode.time = -1;
        stack.push(encode);

        encode = new Encode();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                encode.time = encode.time * 10 + (c - '0');
            }
            if (c == '[') {
                stack.push(encode);
                encode = new Encode();
            }
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                stack.peek().str.append(c);
            }
            if (c == ']') {
                Encode temp = stack.pop();
                for (int i = 0; i < temp.time; i++) {
                    stack.peek().str.append(temp.str);
                }
            }
        }

        return stack.peek().str.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.decodeString("3[a]2[b4[F]c]");

        System.out.println(result);
    }

}
