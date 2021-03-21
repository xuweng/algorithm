package com.leetcode.tag.dp.one.three;

/**
 * 518. 零钱兑换 II
 */
public class Change {
    class Solution {
        public int change(int amount, int[] coins) {
            if (coins == null || coins.length == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i >= coin) {
                        dp[i] += dp[i - coin];
                    }
                }
            }

            return dp[amount];
        }
    }
}
