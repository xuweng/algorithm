package com.leetcode.tag.must.three;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

            return dp[amount] == Integer.MIN_VALUE ? -1 : dp[amount];
        }
    }
}
