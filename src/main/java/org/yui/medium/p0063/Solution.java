package org.yui.medium.p0063;

/**
 * @program: leetcode
 * @description: 63. 不同路径 II
 * @author: YuI
 * @date 2020-07-06 20:52
 **/
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rightEnd = obstacleGrid[0].length;
        int bottomEnd = obstacleGrid.length;

        int[] postion = new int[rightEnd];

        postion[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < bottomEnd; i++) {
            for (int j = 0; j < rightEnd; j++) {
                if (obstacleGrid[i][j] == 1) {
                    postion[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    postion[j] += postion[j - 1];
                }
            }
        }

        return postion[rightEnd - 1];
    }

    public static void main(String[] args) {

        int[][] question1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] question2 = new int[][]{
                {0, 0}
        };

        Solution solution = new Solution();
        int result = solution.uniquePathsWithObstacles(question1);

        System.out.println(result);
    }

}
