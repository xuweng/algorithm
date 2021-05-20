package com.leetcode.tag.must4.four;

/**
 * 96. 不同的二叉搜索树
 * <p>
 * i j 模型
 * <p>
 * i j 模型
 */
public class NumTrees {
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = Math.max(dp[i], dp[j] * dp[i - j - 1]);
                }
            }

            return dp[n];
        }
    }
}
