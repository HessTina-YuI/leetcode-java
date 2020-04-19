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

    /**
     * 动态规划 1
     *
     * @param height 墙高数组
     * @return 接到的雨水总量
     */
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

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int deep = Math.min(maxLeft[i], maxRight[i]);
            if (deep > height[i]) {
                sum += deep - height[i];
            }
        }

        return sum;
    }

    /**
     * 动态规划 2
     *
     * @param height 墙高数组
     * @return 接到的雨水总量
     */
    public int trap2(int[] height) {
        // 当前点右边最高的墙
        int[] maxRight = new int[height.length];

        for (int j = height.length - 2; j > 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j + 1]);
        }

        int maxLeft = 0;
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int deep = Math.min(maxLeft, maxRight[i]);
            if (deep > height[i]) {
                sum += deep - height[i];
            }
        }

        return sum;
    }

    /**
     * 双指针
     *
     * @param height 墙高数组
     * @return 接到的雨水总量
     */
    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int wall = 0;
        int sum = 0;

        while (left < right) {
            // 添加新的木块，可能被淹没，可能成为新的墙
            int block = Math.min(height[left], height[right]);
            // 尝试将木块升级为墙 （更新墙的高度）
            wall = Math.max(wall, block);

            sum += height[left] < height[right] ? wall - height[left++] : wall - height[right--];
        }

        return sum;
    }

    /**
     * 栈的实现
     *
     * @param height 墙高数组
     * @return 接到的雨水总量
     */
    public int trap4(int[] height) {
        int sum = 0;
        // 栈存的为数组的下标，用于保存距离
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < height.length) {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {
                int bottomWater = height[stack.pop()];

                if (stack.isEmpty()) {
                    break;
                }

                int distance = index - stack.peek() - 1;
                int topWall = Math.min(height[index], height[stack.peek()]);

                sum += distance * (topWall - bottomWater);
            }
            stack.push(index++);
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.trap4(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

        System.out.println(result);
    }

}
