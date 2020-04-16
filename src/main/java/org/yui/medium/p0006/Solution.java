package org.yui.medium.p0006;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @package: org.yui.medium.p0006
 * @description: 6. Z 字形变换
 * @author: YuI
 * @create: 2020/4/16 14:34
 **/
public class Solution {

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int index = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(index).append(c);
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }
            index += flag;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(rows.get(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convert("LEETCODEISHIRING", 3);

        System.out.println(result);
    }

}
