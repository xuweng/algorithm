package com.leetcode.tag.must1.two;

import java.util.Arrays;

/**
 * 337. 打家劫舍 III
 */
public class Rob {
    class Solution {
        public int rob(TreeNode root) {
            int[] dfs = dfs(root);

            return Arrays.stream(dfs).max().getAsInt();
        }

        private int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[2];
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int[] dp = new int[2];
            dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            dp[1] = left[0] + right[0] + root.val;

            return dp;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
