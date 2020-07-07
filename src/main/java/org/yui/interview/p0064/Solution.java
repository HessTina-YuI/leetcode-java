package org.yui.interview.p0064;

/**
 * @program: leetcode
 * @package: org.yui.interview.p0064
 * @description: 面试题64. 求1+2+…+n
 * @author: YuI
 * @create: 2020/6/2 0:35 
 **/
public class Solution {

    public int sumNums(int n) {
        boolean result = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.sumNums(2);

        System.out.println(result);
    }

}
