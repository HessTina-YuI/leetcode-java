package org.yui.easy.p0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet-code
 * @description: 1.整数求和
 * @author: YuI
 * @create: 2019-12-30 17:20
 **/
public class Solution {

    public int[] twoSum1(int[] nums, int target) {

        int length = nums.length;
        int sum;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{0, 0};
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum2(nums, target);

        System.out.println(Arrays.toString(result));
    }

}
