package org.yui.medium.p1162;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @package: org.yui.medium.p1162
 * @description: 1162. 地图分析
 * @author: YuI
 * @create: 2020/3/29 2:07
 **/
public class Solution {
    static class Point {
        protected int x;
        protected int y;
        protected int step;

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int maxDistance(int[][] grid) {
        Queue<Point> land = new LinkedList<>();

        // 将陆地的位置放入队列中
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    land.offer(new Point(i, j, 0));
                }
            }
        }

        if (land.isEmpty() || land.size() == grid[0].length * grid.length) {
            return -1;
        }

        Point p = null;
        // 判断队列中的每一块陆地四周的状况，如果有海洋就填补
        while (!land.isEmpty()) {
            p = land.remove();

            // 上方
            if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 0) {
                grid[p.x - 1][p.y] = 1;
                land.add(new Point(p.x - 1, p.y, p.step + 1));
            }

            // 下方
            if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 0) {
                grid[p.x + 1][p.y] = 1;  //填海
                land.add(new Point(p.x + 1, p.y, p.step + 1));
            }

            // 右方
            if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 0) {
                grid[p.x][p.y + 1] = 1;
                land.add(new Point(p.x, p.y + 1, p.step + 1));
            }

            // 左方
            if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 0) {
                grid[p.x][p.y - 1] = 1;
                land.add(new Point(p.x, p.y - 1, p.step + 1));
            }
        }

        return p.step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data1 = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        int[][] data2 = new int[][]{
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}
        };

        int result = solution.maxDistance(data2);

        System.out.println(result);
    }
}
