package com.leetcode.tag.dp.three;

/**
 * 322. 零钱兑换
 */
public class CoinChange2 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                dp[i] = Integer.MIN_VALUE;
                for (int coin : coins) {
                    if (coin <= i && dp[i - coin] != Integer.MIN_VALUE) {
                        dp[i] = Math.max(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == Integer.MIN_VALUE ? -1 : dp[amount];
        }
    }
}
