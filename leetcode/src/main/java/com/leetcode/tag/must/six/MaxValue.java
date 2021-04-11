package com.leetcode.tag.must.six;

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
            int l = 0;
            int r = 0;
            for (int i = 0; i <= k; i++) {
                l = Math.max(l, left[i]);
                r = Math.max(r, right[i]);
            }
            // 不软色
            dp[0] = l + r;
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
