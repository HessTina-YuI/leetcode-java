package org.yui.medium.p0046;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0046
 * @description: 46. 全排列
 * @author: YuI
 * @create: 2020/4/25 23:44
 **/
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;

        backtrack(n, output, res, 0);

        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
            return;
        }

        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(new int[]{1, 2, 3});

        if (res == null) {
            return;
        }

        res.forEach(a -> {
            a.forEach(b -> {
                System.out.print(b);
                System.out.print(" ");
            });
            System.out.println();
        });
    }
}
