package org.yui.easy.p0088;

/**
 * @program: leetcode
 * @description: 88.合并两个有序数组
 * @author: yui
 * @create: 2020-01-05 19:21
 **/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};

        Solution solution = new Solution();
        solution.merge(nums1, 0, nums2, 1);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
