package com.leetcode.tag.must1.nine;

/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[][] dp = new int[m][n];
            dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        continue;
                    }
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    } else if (i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    class Solution1 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[] dp = new int[n];
            // 初始化0行
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] == 1) {
                    continue;
                }
                if (i > 0 && obstacleGrid[0][i - 1] == 1) {
                    continue;
                }
                dp[i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                        continue;
                    }
                    if (obstacleGrid[i][j - 1] == 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }

            return dp[n - 1];
        }
    }

    class Solution2 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[] dp = new int[n];
            for (int[] ints : obstacleGrid) {
                for (int j = 0; j < n; j++) {
                    if (ints[j] == 1) {
                        dp[j] = 0;
                        continue;
                    }
                    if (j > 0 && ints[j - 1] == 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
