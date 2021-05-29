package com.leetcode.tag.must5.three;

/**
 * 518. 零钱兑换 II
 */
public class Change {
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            return dp[amount];
        }
    }
}
