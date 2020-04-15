package org.yui.medium.p0542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0542
 * @description: 542. 01 矩阵
 * @author: YuI
 * @create: 2020/4/15 15:42
 **/
public class Solution {

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int[][] updateMatrix(int[][] matrix) {
        Queue<Point> pointQueue = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    pointQueue.offer(new Point(i, j));
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (!pointQueue.isEmpty()) {
            Point p = pointQueue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];
                if (newX >= 0 &&
                        newX < matrix.length &&
                        newY >= 0 &&
                        newY < matrix[0].length &&
                        matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[p.x][p.y] + 1;
                    pointQueue.offer(new Point(newX, newY));
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] source1 = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };

        int[][] source2 = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        };

        int[][] source3 = new int[][]{
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        };


        int[][] result = solution.updateMatrix(source3);

        Arrays.stream(result)
                .forEach(a -> {
                    Arrays.stream(a).forEach(b -> {
                        System.out.print(b);
                        System.out.print(" ");
                    });
                    System.out.println();
                });

    }

}
