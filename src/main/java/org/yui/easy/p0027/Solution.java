package org.yui.easy.p0027;

/**
 * @program: leet-code
 * @description: 27.移除元素
 * @author: YuI
 * @create: 2019-12-30 21:35
 **/
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int newLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[newLength] = nums[i];
                newLength++;
            }
        }

        return newLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int result = solution.removeElement(nums, 2);

        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
}
