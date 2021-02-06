package com.leetcode.tag.dp.one.two.eight;

/**
 * 337. 打家劫舍 III
 */
public class Rob5 {
    class Solution {
        public int rob(TreeNode root) {
            int[] ints = myRob(root);

            return Math.max(ints[0], ints[1]);
        }

        private int[] myRob(TreeNode root) {
            if (root == null) {
                return new int[2];
            }
            int[] left = myRob(root.left);
            int[] right = myRob(root.right);

            int[] dp = new int[2];
            dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            dp[1] = root.val + left[0] + right[0];

            return dp;
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
