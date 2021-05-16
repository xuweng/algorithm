package com.leetcode.tag.must5.one;

/**
 * 5762. 恰有 K 根木棍可以看到的排列数目
 */
public class RearrangeSticks {
    class Solution {
        int mod = (int) (1e9 + 7);

        public int rearrangeSticks(int n, int k) {
            int[][] dp = new int[n + 1][k + 1];
            // 长度 长度 长度
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = dp[i - 1][j - 1];
                    dp[i][j] += dp[i - 1][j] * (i - 1);
                    dp[i][j] %= mod;
                }
            }

            return dp[n][k];
        }
    }
}
