package com.leetcode.tag.must2.one;

import java.util.Arrays;

/**
 * 64. 最小路径和
 */
public class MinPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            int n = grid[0].length;
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int[] ints : grid) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        dp[j] += ints[j];
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - 1]) + ints[j];
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
