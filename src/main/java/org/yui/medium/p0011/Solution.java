package org.yui.medium.p0011;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0011
 * @description: 11. 盛最多水的容器
 * @author: YuI
 * @create: 2020/4/14 16:06
 **/
public class Solution {

    public int maxArea1(int[] height) {
        int max = 0;
        int area;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(area, max);
            }
        }

        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int minHeight;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            minHeight = Math.min(height[left], height[right]);
            max = Math.max((right - left) * minHeight, max);

            while (left < right && height[left] <= minHeight) {
                left++;
            }
            while (left < right && height[right] <= minHeight) {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});

        System.out.println(result);
    }

}
