package com.leetcode.tag.must3.six;

/**
 * 1269. 停在原地的方案数
 */
public class NumWays {
    class Solution {
        int mod = (int) (1e9 + 7);

        public int numWays(int steps, int arrLen) {
            // 最远下标
            int max = Math.min(steps / 2, arrLen - 1);
            int[][] dp = new int[steps + 1][max + 1];
            dp[0][0] = 1;

            for (int i = 1; i <= steps; i++) {
                for (int j = 0; j <= max; j++) {
                    // 不动
                    dp[i][j] = dp[i - 1][j];
                    if (j - 1 >= 0) {
                        // 向右移动
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                    }
                    if (j + 1 <= max) {
                        // 向左移动
                        dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                    }
                }
            }

            return dp[steps][0];
        }
    }
}
