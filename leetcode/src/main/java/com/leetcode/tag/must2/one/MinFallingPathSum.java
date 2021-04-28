package com.leetcode.tag.must2.one;

import java.util.Arrays;

/**
 * 931. 下降路径最小和
 */
public class MinFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        dp[i][j] = matrix[i][j];
                        continue;
                    }
                    if (j > 0 && j < n - 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
                    } else if (j > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                    } else if (j < n - 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                    }
                }
            }

            return Arrays.stream(dp[m - 1]).min().getAsInt();
        }
    }
}
