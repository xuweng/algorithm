package com.leetcode.tag.must2;

/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[] dp = new int[n];
            dp[0] = 1;

            for (int[] ints : obstacleGrid) {
                for (int j = 0; j < n; j++) {
                    if (ints[j] == 1) {
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
