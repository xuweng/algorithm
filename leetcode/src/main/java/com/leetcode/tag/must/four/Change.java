package com.leetcode.tag.must.four;

/**
 * 518. 零钱兑换 II
 * <p>
 * 初始化 一半初始化
 */
public class Change {
    class Solution {
        public int change(int amount, int[] coins) {
            if (coins == null) {
                return 0;
            }
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
