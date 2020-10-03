package com.leetcode.tag.tree.six;

/**
 * 101. 对称二叉树
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
            if (root1 == null || root.val != root1.val) {
                return false;
            }
            return isSymmetric(root.left, root1.right) && isSymmetric(root.right, root1.left);
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
