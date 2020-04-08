package org.yui.interview.p0013;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @package: org.yui.interview.p0013
 * @description: 面试题13. 机器人的运动范围
 * @author: YuI
 * @create: 2020/4/8 22:45
 **/
public class Solution {

    int count = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];

        dfs(visited, 0, 0, m, n, k);

        return count;
    }

    private void dfs(boolean[][] visited, int i, int j, int m, int n, int k) {
        if (i < m && j < n && !visited[i][j] && isLessK(i, j, k)) {
            count++;
            visited[i][j] = true;
            dfs(visited, i + 1, j, m, n, k);
            dfs(visited, i, j + 1, m, n, k);
        }
    }

    private boolean isLessK(int row, int col, int k) {
        int sum = 0;
        while (row > 0 || col > 0) {
            sum += row % 10;
            sum += col % 10;
            row = row != 0 ? row / 10 : 0;
            col = col != 0 ? col / 10 : 0;
        }

        return sum <= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.movingCount(3, 1, 0);

        System.out.println(result);
    }
}
