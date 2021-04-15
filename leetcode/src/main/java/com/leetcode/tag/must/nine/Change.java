package com.leetcode.tag.must.nine;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class Change {
    class Solution {
        public int change(int amount, int[] coins) {
            if (coins == null) {
                return 0;
            }
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
