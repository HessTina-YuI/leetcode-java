package org.yui.easy.p0892;

/**
 * @program: leetcode
 * @package: org.yui.easy.p0892
 * @description: 892. 三维形体的表面积
 * @author: YuI
 * @create: 2020/3/25 16:17
 **/
public class Solution {

    public int surfaceArea(int[][] grid) {
        int accountArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                accountArea += getFaceNum(grid, i, j);
            }
        }

        return accountArea;
    }

    private int getFaceNum(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int faceNum = grid[i][j] * 4 + 2;
        if (i - 1 >= 0) {
            faceNum -= Math.min(grid[i][j], grid[i - 1][j]);
        }
        if (j - 1 >= 0) {
            faceNum -= Math.min(grid[i][j], grid[i][j - 1]);
        }
        if (i + 1 < grid.length) {
            faceNum -= Math.min(grid[i][j], grid[i + 1][j]);
        }
        if (j + 1 < grid[i].length) {
            faceNum -= Math.min(grid[i][j], grid[i][j + 1]);
        }
        return faceNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}});

        System.out.println(result);
    }
}
