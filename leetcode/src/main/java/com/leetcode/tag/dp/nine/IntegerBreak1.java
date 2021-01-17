package com.leetcode.tag.dp.nine;

/**
 * 343. 整数拆分
 * <p>
 * 尽量做对 尽量做对
 */
public class IntegerBreak1 {
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }

            return dp[n];
        }
    }
}
