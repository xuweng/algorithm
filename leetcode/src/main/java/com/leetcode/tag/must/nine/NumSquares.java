package com.leetcode.tag.must.nine;

import java.util.Arrays;

/**
 * 279. 完全平方数
 */
public class NumSquares {
    class Solution {
        public int numSquares(int n) {
            int max = (int) Math.sqrt(n);
            int[] coins = new int[max + 1];
            for (int i = 1; i <= max; i++) {
                coins[i] = i * i;
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;

            for (int coin : coins) {
                for (int i = coin; i <= n; i++) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

            return dp[n];
        }
    }
}
