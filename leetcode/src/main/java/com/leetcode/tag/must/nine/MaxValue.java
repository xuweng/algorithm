package com.leetcode.tag.must.nine;

import java.util.Arrays;

/**
 * LCP 34. 二叉树染色
 */
public class MaxValue {
    class Solution {
        public int maxValue(TreeNode root, int k) {
            int[] dfs = dfs(root, k);

            return Arrays.stream(dfs).max().getAsInt();
        }

        private int[] dfs(TreeNode root, int k) {
            if (root == null) {
                return new int[k + 1];
            }
            int[] left = dfs(root.left, k);
            int[] right = dfs(root.right, k);
            int[] dp = new int[k + 1];
            int lMax = 0, rMax = 0;
            for (int i = 0; i <= k; i++) {
                lMax = Math.max(lMax, left[i]);
                rMax = Math.max(rMax, right[i]);
            }
            dp[0] = lMax + rMax;
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = Math.max(dp[i], left[j] + right[i - j - 1] + root.val);
                }
            }

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
