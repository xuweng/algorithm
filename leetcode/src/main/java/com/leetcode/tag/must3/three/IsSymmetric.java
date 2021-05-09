package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 28. 对称的二叉树
 */
public class IsSymmetric {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return dfs(root, root);
        }

        private boolean dfs(TreeNode root, TreeNode root1) {
            if (root == null) {
                return root1 == null;
            }
            if (root1 == null) {
                return false;
            }

            return root.val == root1.val && dfs(root.left, root1.right) && dfs(root.right, root1.left);
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
