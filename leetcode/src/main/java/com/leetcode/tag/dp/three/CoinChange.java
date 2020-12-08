package com.leetcode.tag.dp.three;

/**
 * 322. 零钱兑换
 * <p>
 * 回溯 break return
 * <p>
 * 回溯 break return
 * <p>
 * 前i。前i。前i。前i。前i。前i。前i。前i。
 * <p>
 * 递归树 矩阵
 * <p>
 * 递归树 矩阵
 * <p>
 * 递归树 矩阵
 * <p>
 * 递归树 矩阵
 */
public class CoinChange {
    class Solution {
        /**
         * 子问题无解?
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i - coin], dp[i]) + 1;
                    }
                }
            }

            return dp[amount] == Integer.MAX_VALUE ? 0 : dp[amount];
        }
    }
}
