package com.leetcode.tag.tree.two;

/**
 * 剑指 Offer 28. 对称的二叉树
 */
public class IsSymmetric {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root, root);
        }

        public boolean isSymmetric(TreeNode root, TreeNode root1) {
            if (root == null) {
                return root1 == null;
            }
            if (root1 == null) {
                return false;
            }
            return root.val == root1.val && isSymmetric(root.left, root1.right) && isSymmetric(root.right, root1.left);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
