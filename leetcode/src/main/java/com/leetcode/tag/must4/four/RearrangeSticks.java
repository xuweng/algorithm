package com.leetcode.tag.must4.four;

/**
 * 1866. 恰有 K 根木棍可以看到的排列数目
 */
public class RearrangeSticks {
    class Solution {
        int mod = (int) (1e9 + 7);

        public int rearrangeSticks(int n, int k) {
            int[][] dp = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    // 前i-1个看到j-1个
                    dp[i][j] = dp[i - 1][j - 1];
                    // 前i-1个看到j个 最后一个[1,i-1] 比i小
                    dp[i][j] += dp[i - 1][j] * (i - 1);
                    dp[i][j] %= mod;
                }
            }

            return dp[n][k];
        }
    }
}
