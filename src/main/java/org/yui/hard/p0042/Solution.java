package org.yui.hard.p0042;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * @program: leetcode
 * @package: org.yui.hard.p0042
 * @description: 42. 接雨水
 * @author: YuI
 * @create: 2020/4/4 0:14
 **/
public class Solution {

    public int trap1(int[] height) {
        // 当前点左边最高的墙
        int[] maxLeft = new int[height.length];
        // 当前点右边最高的墙
        int[] maxRight = new int[height.length];

        // 最右边的墙不需要考虑
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        // 最左边的墙不需要考虑
        for (int j = height.length - 2; j > 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j + 1]);
        }

        int count = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int deep = Math.min(maxLeft[i], maxRight[i]);
            if (deep > height[i]) {
                count += deep - height[i];
            }
        }

        return count;
    }

    public int trap2(int[] height) {
        // 当前点右边最高的墙
        int[] maxRight = new int[height.length];

        for (int j = height.length - 2; j > 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j + 1]);
        }

        int maxLeft = 0;
        int count = 0;
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int deep = Math.min(maxLeft, maxRight[i]);
            if (deep > height[i]) {
                count += deep - height[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

        System.out.println(result);
    }

}
