package org.yui.medium.p0945;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 945. 使数组唯一的最小增量
 * @author: YuI
 * @create: 2020/3/22 1:18
 **/
public class Solution {

    public int minIncrementForUnique1(int[] A) {
        Arrays.sort(A);

        int count = 0;

        int temp = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == temp) {
                for (int j = i; j < A.length; j++) {
                    if (A[j] == temp) {
                        A[j]++;
                        count++;
                    } else {
                        break;
                    }
                }
            }

            temp = A[i];
        }

        return count;
    }

    public int minIncrementForUnique2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] change = new int[50000];
        int count = 0;

        for (int num : A) {
            change[num]++;
        }

        for (int i = 0; i < change.length; i++) {
            if (change[i] > 1) {
                count += change[i] - 1;
                change[i + 1] += change[i] - 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.minIncrementForUnique2(new int[]{3, 4, 1, 2, 5, 7});

        System.out.println(result);
    }
}
