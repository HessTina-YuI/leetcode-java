package org.yui.medium.p0022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0022
 * @description: 22. 括号生成
 * @author: YuI
 * @create: 2020/4/9 13:41
 **/
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int left, int right, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur.toString());
            return;
        }

        if (left < max) {
            cur.append("(");
            backtrack(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (right < left) {
            cur.append(")");
            backtrack(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(3);

        result.forEach(System.out::println);
    }
}
