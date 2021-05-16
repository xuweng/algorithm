package com.leetcode.tag.contest.five;

/**
 * 5762. 恰有 K 根木棍可以看到的排列数目
 */
public class RearrangeSticks {
    class Solution {
        public int rearrangeSticks(int n, int k) {
            long[][] dp = new long[n + 1][n + 1];
            dp[0][0] = 1;
            long mod = (long) 1e9 + 7;
            for (int i = 1; i <= n; i++) {
                dp[i][i] = 1;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + ((i - 1) * dp[i - 1][j]) % mod;
                    dp[i][j] = (dp[i][j] + mod) % mod;
                }
            }
            return (int) dp[n][k];
        }
    }

    /**
     * 方法一：动态规划
     */
    class Solution1 {
        private int mod = (int) 1e9 + 7;

        public int rearrangeSticks(int n, int k) {
            //  f(i, j) 表示长度为 1,2,⋯,i 的木棍且可以可以看到其中的 j 根木棍的方案数
            long[][] dp = new long[n + 1][k + 1];
            dp[0][0] = 1;
            // 在进行状态转移的时候，我们可以考虑最后一根木棍是否可以被看到
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= Math.min(k, i); j++) {
                    // 如果可以被看到，最后一根木棍的长度一定为 j，因此前 i-1根木棍的长度恰好为 1,2,⋯i−1 的一个排列，并且可以看到其中的 j−1 根木棍
                    dp[i][j] = dp[i - 1][j - 1];
                    if (i - 1 >= j) {
                        dp[i][j] += (i - 1) * dp[i - 1][j];
                    }
                    dp[i][j] %= mod;
                }
            }
            return (int) dp[n][k];
        }
    }
}
