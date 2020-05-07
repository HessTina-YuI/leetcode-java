package org.yui.easy.p0572;

import org.yui.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
 * @description: 409. 最长回文串
 * @author: YuI
 * @create: 2020/5/7 10:32
 **/
public class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            boolean isSame = false;
            if (temp.val == t.val) {
                isSame = isSameTree(temp, t);
            }

            if (isSame) {
                return true;
            }

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return false;
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        boolean isLeftSame;
        boolean isRightSame;

        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null || a.val != b.val) {
            return false;
        }

        isLeftSame = isSameTree(a.left, b.left);
        isRightSame = isSameTree(a.right, b.right);

        return isLeftSame && isRightSame;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);
        s.right = new TreeNode(5);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        boolean result = solution.isSubtree(s, t);
        System.out.println(result);
    }

}
