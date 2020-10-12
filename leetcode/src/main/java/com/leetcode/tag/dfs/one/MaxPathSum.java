package com.leetcode.tag.dfs.one;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 结合 数组的最大子数组和 的思路去解题
 * 动态规划： dp[i] 代表以 nums[i] 为结尾的子数组的最大和。
 * 转移方程： dp[i] = max(dp[i-1], 0) + nums[i]。
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
