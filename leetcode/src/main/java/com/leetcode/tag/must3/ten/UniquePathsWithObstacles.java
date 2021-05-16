package com.leetcode.tag.must3.ten;

/**
 * 63. 不同路径 II
 * <p>
 * 位置 位置 位置
 * <p>
 * 移动指针 移动指针 移动指针
 */
public class UniquePathsWithObstacles {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[] dp = new int[n];
            dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        // 置0
                        dp[j] = 0;
                        continue;
                    }
                    if (j > 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
