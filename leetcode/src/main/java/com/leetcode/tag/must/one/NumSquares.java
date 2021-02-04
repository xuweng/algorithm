package com.leetcode.tag.must.one;

/**
 * 279. 完全平方数
 */
public class NumSquares {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                dp[i] = 1;
                for (int j = 1; j < i; j++) {
                    if (j * j <= i) {
                        dp[i] = Math.min(dp[i], dp[i - j * j]);
                    }
                }
            }

            return dp[n];
        }
    }
}
