package com.leetcode.tag.dfs.one;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 分析.
 * <p>
 * dp.dp.dp.dp.
 */
public class MaxPathSum {
    class Solution {
        int result = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            sum(root);

            return result;
        }

        public int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, sum(root.left));
            int right = Math.max(0, sum(root.right));

            result = Math.max(result, root.val + left + right);

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
