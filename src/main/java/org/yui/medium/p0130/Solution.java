package org.yui.medium.p0130;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 130. 被围绕的区域
 * @author: YuI
 * @create: 2020-08-11 11:06
 **/
public class Solution {

    private static int[] rowP = {1, -1, 0, 0};
    private static int[] colP = {0, 0, 1, -1};

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            dft(board, i, 0);
            dft(board, i, board[0].length - 1);
        }

        for (int i = 1; i < board[0].length - 1; i++) {
            dft(board, 0, i);
            dft(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dft(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        if (board[row][col] == 'O') {
            board[row][col] = 'A';
        } else {
            return;
        }

        for (int i = 0; i < 4; i++) {
            dft(board, row + rowP[i], col + colP[i]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] question1 = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        char[][] question2 = new char[][]{{'O'}};

        char[][] question3 = new char[][]{
                {'O', 'O'},
                {'O', 'O'}
        };

        solution.solve(question3);

        Arrays.stream(question3).forEach(a -> System.out.println(Arrays.toString(a)));
    }

}
