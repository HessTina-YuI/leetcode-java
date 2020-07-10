package org.yui.easy.p0112;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.yui.structure.TreeNode;

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * @program: leetcode
 * @description: 112. 路径总和
 * @author: YuI
 * @date 2020-07-07 10:21
 **/
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);

        TreeNode root2 = new TreeNode(1);

        Solution solution = new Solution();

        boolean result = solution.hasPathSum(root1, 22);
        System.out.println(result);
    }

}
