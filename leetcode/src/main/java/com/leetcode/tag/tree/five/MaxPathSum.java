package com.leetcode.tag.tree.five;

/**
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum {
    class Solution {
        int result;

        public int maxPathSum(TreeNode root) {
            dfs(root);

            return result;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            left = Math.max(left, 0);
            int right = dfs(root.right);
            right = Math.max(right, 0);

            result = Math.max(result, root.val) + left + right;

            return Math.max(left, right) + root.val;
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
