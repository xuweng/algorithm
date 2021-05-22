package com.leetcode.tag.must4.six;

/**
 * 343. 整数拆分
 */
public class IntegerBreak {
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }

            return dp[n];
        }
    }
}
