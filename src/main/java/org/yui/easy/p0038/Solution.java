package org.yui.easy.p0038;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @program: leet-code
 * @description: 38.报数
 * @author: yui
 * @create: 2019-12-30 22:16
 **/
public class Solution {
    public String countAndSay1(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int count;
        int nextCount = 1;

        for (int i = 1; i < n; i++) {
            count = nextCount;
            Integer temp = queue.peek();
            int account = 0;
            for (int j = 0; j < count; j++) {
                if (Objects.equals(temp, queue.peek())) {
                    queue.poll();
                    account++;
                    nextCount--;
                } else {
                    queue.offer(account);
                    queue.offer(temp);
                    temp = queue.peek();
                    j--;
                    account = 0;
                    nextCount += 2;
                }

                if (j == count - 1) {
                    queue.offer(account);
                    queue.offer(temp);
                    nextCount += 2;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : queue) {
            stringBuilder.append(num);
        }

        return stringBuilder.toString();
    }

    public String countAndSay2(int n) {
        String s = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char temp = s.charAt(0);
            int count = 0;
            int length = s.length();
            for (int j = 0; j < length; j++) {
                if (temp == s.charAt(j)) {
                    count++;
                } else {
                    stringBuilder.append(count);
                    stringBuilder.append(temp);
                    temp = s.charAt(j);
                    count = 0;
                    j--;
                }

                if (j == s.length() - 1) {
                    stringBuilder.append(count);
                    stringBuilder.append(temp);
                    s = stringBuilder.toString();
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.countAndSay2(30);

        System.out.println(result);
    }
}
