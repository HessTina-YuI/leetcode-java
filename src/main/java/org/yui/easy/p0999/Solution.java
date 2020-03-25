package org.yui.easy.p0999;

/**
 * @program: leetcode
 * @package: org.yui.easy.p0999
 * @description: 999. 车的可用捕获量
 * @author: YuI
 * @create: 2020/3/26 1:50
 **/
public class Solution {

    public int numRookCaptures(char[][] board) {
        int account = 0;
        int row = 0, col = 0;
        boolean isFind = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }

        // 上
        for (int k = col; k >= 0; k--) {
            if (board[row][k] == 'p') {
                account++;
                break;
            }
            if (board[row][k] == 'B') {
                break;
            }
        }

        // 右
        for (int k = row; k < 8; k++) {
            if (board[k][col] == 'p') {
                account++;
                break;
            }
            if (board[k][col] == 'B') {
                break;
            }
        }

        // 下
        for (int k = col; k < 8; k++) {
            if (board[row][k] == 'p') {
                account++;
                break;
            }
            if (board[row][k] == 'B') {
                break;
            }
        }

        // 左
        for (int k = row; k >= 0; k--) {
            if (board[k][col] == 'p') {
                account++;
                break;
            }
            if (board[k][col] == 'B') {
                break;
            }
        }

        return account;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] start_1 = new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        char[][] start_2 = new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        char[][] start_3 = new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};

        int result = solution.numRookCaptures(start_3);

        System.out.println(result);
    }
}
