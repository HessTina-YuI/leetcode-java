package org.yui.medium.p1248;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @package: org.yui.medium.p1248
 * @description: 1248. 统计「优美子数组」
 * @author: YuI
 * @create: 2020/4/21 16:47
 **/
public class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        int preEven = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if ((num & 1) == 0) {
                preEven++;
            } else {
                list.add(preEven + 1);
                preEven = 0;
            }
        }
        list.add(preEven + 1);

        int sum = 0;
        for (int i = 0; i < list.size() - k; i++) {
            sum += list.get(i) * list.get(i + k);
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);

        System.out.println(result);
    }

}
