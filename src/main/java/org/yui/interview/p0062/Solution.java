package org.yui.interview.p0062;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @package: org.yui.interview.p0062
 * @description: 面试题62. 圆圈中最后剩下的数字
 * @author: YuI
 * @create: 2020/3/30 0:08
 **/
public class Solution {
    public int lastRemaining1(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int delete = 0;
        while (list.size() > 1) {
            delete = (delete + m - 1) % list.size();
            list.remove(delete);
        }

        return list.get(0);
    }

    // 约瑟夫环
    public int lastRemaining2(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lastRemaining2(5, 3);

        System.out.println(result);
    }
}
