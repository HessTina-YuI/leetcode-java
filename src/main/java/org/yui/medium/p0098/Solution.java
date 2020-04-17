package org.yui.medium.p0098;

import org.yui.structure.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 *
 * @program: leetcode
 * @package: org.yui.medium.p0098
 * @description: 98. 验证二叉搜索树
 * @author: YuI
 * @create: 2020/4/17 22:15
 **/
public class Solution {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double index = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= index) {
                return false;
            }
            index = root.val;
            root = root.right;
        }

        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        boolean result = solution.isValidBST(root);

        System.out.println(result);
    }

}
