package org.yui.interview.p01_07;

import java.util.Arrays;

/**
 * @program: leetcode
 * @package: org.yui.interview.p01_07
 * @description: 面试题 01.07. 旋转矩阵
 * @author: YuI
 * @create: 2020/4/7 14:49
 **/
public class Solution {

    public void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        for (int row = 0; row <= length / 2; row++) {
            for (int col = row; col < length - row; col++) {
                rotateFourPoint(matrix, row, col);
            }
        }
    }

    // 旋转四个点
    private void rotateFourPoint(int[][] matrix, int row, int col) {
        int length = matrix.length - 1;
        int temp = matrix[row][col];
        matrix[row][col] = matrix[length - col][row];
        matrix[length - col][row] = matrix[length - row][length - col];
        matrix[length - row][length - col] = matrix[col][length - row];
        matrix[col][length - row] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        solution.rotate(matrix2);

        Arrays.stream(matrix2)
                .forEach(a -> {
                    Arrays.stream(a).forEach(b -> {
                        System.out.print(b);
                        System.out.print(" ");
                    });
                    System.out.println();
                });
    }
}
