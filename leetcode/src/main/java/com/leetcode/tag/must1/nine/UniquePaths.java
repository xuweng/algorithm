package com.leetcode.tag.must1.nine;

import java.util.Arrays;

/**
 * 62. 不同路径
 */
public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
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
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            // 初始化0行
            Arrays.fill(dp, 1);

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }

            return dp[n - 1];
        }
    }
}
