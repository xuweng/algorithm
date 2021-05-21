package com.leetcode.tag.must4.five;

/**
 * 343. 整数拆分
 */
public class IntegerBreak {
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }

            return dp[n];
        }
    }
}
