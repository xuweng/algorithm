package com.leetcode.tag.must1.nine;

import java.util.Arrays;

/**
 * 64. 最小路径和
 * <p>
 * 只有正数
 * <p>
 * 有负数
 * <p>
 * 如果方块中存在负权，如何求解？
 */
public class MinPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                    } else if (i > 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    class Solution1 {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int[] ints : grid) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        dp[j] += +ints[j];
                    } else {
                        // j-1代表本层左一个 正序
                        dp[j] = Math.min(dp[j - 1], dp[j]) + ints[j];
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
