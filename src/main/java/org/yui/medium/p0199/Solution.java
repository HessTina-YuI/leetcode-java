package org.yui.medium.p0199;

import org.yui.structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
 * @package: org.yui.medium.p0199
 * @description: 199. 二叉树的右视图
 * @author: YuI
 * @create: 2020/4/22 0:43
 **/
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return list;
        }
        deque.offerLast(root);

        while (deque.size() > 0) {
            int num = deque.size();
            TreeNode temp = deque.peekLast();
            list.add(temp.val);

            for (int i = 0; i < num; i++) {
                temp = deque.pollFirst();
                if (temp.left != null) {
                    deque.offerLast(temp.left);
                }
                if (temp.right != null) {
                    deque.offerLast(temp.right);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> result = solution.rightSideView(root);

        result.forEach(a -> {
            System.out.print(a);
            System.out.print(" ");
        });
    }
}
