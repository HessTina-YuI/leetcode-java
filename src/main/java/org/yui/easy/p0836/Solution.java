package org.yui.easy.p0836;

/**
 * @program: leetcode
 * @description: 836. 矩形重叠
 * @author: YuI
 * @create: 2020/3/18 20:08
 **/
public class Solution {
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        // 矩形1相对矩形2的位置
        return !(rec1[2] <= rec2[0] ||      //left
                rec1[3] <= rec2[1] ||       //bottom
                rec1[0] >= rec2[2] ||       //right
                rec1[1] >= rec2[3]);        //top
    }

    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        // 矩形1和矩形2的投影是否相交
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&      // x轴投影
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));       // y轴投影
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isRectangleOverlap2(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1});

        System.out.println(result);
    }
}
