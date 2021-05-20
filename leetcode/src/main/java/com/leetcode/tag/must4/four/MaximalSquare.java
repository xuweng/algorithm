package com.leetcode.tag.must4.four;

/**
 * 221. 最大正方形
 */
public class MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            int max = 0;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '0') {
                        continue;
                    }
                    if (i == 0 || j == 0) {
                        // 边界
                        dp[i][j] = 1;
                    } else {
                        // 三取小
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }

            return max * max;
        }
    }
}
