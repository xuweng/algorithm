package com.leetcode.tag.must5.ten;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;

            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

            return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
        }
    }
}
