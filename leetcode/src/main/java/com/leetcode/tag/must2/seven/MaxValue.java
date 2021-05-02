package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * <p>
 * 路程一样
 */
public class MaxValue {
    /**
     * 依赖 依赖 依赖
     * <p>
     * 可变参数 可变参数 可变参数
     * <p>
     * 依赖上一层 依赖本层
     */
    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[] dp = new int[n];
            dp[0] = grid[0][0];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0) {
                        dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
                    } else if (i > 0) {
                        dp[j] = dp[j] + grid[i][j];
                    } else if (j > 0) {
                        dp[j] = dp[j - 1] + grid[i][j];
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
