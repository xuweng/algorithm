package com.leetcode.tag.must3.ten;

/**
 * 1269. 停在原地的方案数
 */
public class NumWays {
    class Solution {
        int mod = (int) (1e9 + 7);

        public int numWays(int steps, int arrLen) {
            int max = Math.min(steps / 2, arrLen - 1);
            int[][] dp = new int[steps + 1][max + 1];
            dp[0][0] = 1;

            for (int i = 1; i <= steps; i++) {
                for (int j = 0; j <= max; j++) {
                    // 不动
                    dp[i][j] = dp[i - 1][j];
                    // 右移动
                    if (j - 1 >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                    }
                    // 左移动
                    if (j + 1 <= max) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                    }
                }
            }

            return dp[steps][0];
        }
    }
}
