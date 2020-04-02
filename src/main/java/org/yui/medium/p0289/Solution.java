package org.yui.medium.p0289;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0289
 * @description: 289. 生命游戏
 * @author: YuI
 * @create: 2020/4/2 22:27
 **/
public class Solution {

    public void gameOfLife(int[][] board) {
        int[] neighbors = new int[]{-1, 0, 1};

        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                count += 1;
                            }
                        }
                    }
                }

                /*
                    0: 过去和现在都是死的
                    1: 过去现在都是活的
                    -1: 过去是活的，现在是死的
                    2: 过去是死的，现在是活的
                 */
                // 规则1和3
                if (board[row][col] == 1 && (count < 2 || count > 3)) {
                    board[row][col] = -1;
                }
                // 规则4
                if (board[row][col] == 0 && count == 3) {
                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                }
                if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] start = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        solution.gameOfLife(start);

        for (int[] row : start) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
