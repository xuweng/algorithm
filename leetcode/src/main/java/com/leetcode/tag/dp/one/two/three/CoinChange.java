package com.leetcode.tag.dp.one.two.three;

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
         * 子问题无解?子问题无解？子问题无解?子问题无解?
         * <p>
         * 搞清楚状态。搞清楚状态。搞清楚状态。搞清楚状态。
         * <p>
         * 前i。前j。前i。前j。前i。前j。
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
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
            }

            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
