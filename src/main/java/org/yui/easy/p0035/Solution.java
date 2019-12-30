package org.yui.easy.p0035;

/**
 * @program: leet-code
 * @description: 35.搜索插入位置
 * @author: yui
 * @create: 2019-12-30 22:03
 **/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.searchInsert(new int[]{1, 3, 5, 6}, 7);

        System.out.println(result);
    }
}
