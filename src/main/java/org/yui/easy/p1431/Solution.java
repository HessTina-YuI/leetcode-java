package org.yui.easy.p1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @package: org.yui.easy.p1431
 * @description: 1431. 拥有最多糖果的孩子
 * @author: YuI
 * @create: 2020/6/2 0:12 
 **/
public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        final int maxCandies = Arrays.stream(candies).max().orElse(Integer.MIN_VALUE);

        List<Boolean> result = new ArrayList<>(candies.length);

        Arrays.stream(candies).forEach(candy -> result.add(candy + extraCandies >= maxCandies));

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Boolean> result = solution.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1);

        result.forEach(a -> System.out.print(a + " "));
    }

}
