package org.yui.medium.p0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0056
 * @description: 56. 合并区间
 * @author: YuI
 * @create: 2020/4/16 0:03
 **/
public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        list.add(new int[]{left, right});
        for (int[] interval : intervals) {
            if (interval[0] <= right) {
                list.remove(list.size() - 1);
            } else {
                left = interval[0];
            }
            right = Math.max(right, interval[1]);
            list.add(new int[]{left, right});
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] source1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] source2 = new int[][]{{1, 4}, {4, 5}};
        int[][] source3 = new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};

        int[][] result = solution.merge(source3);
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
