package com.leetcode.tag.dp;

/**
 * 322. 零钱兑换
 * <p>
 * 不刷题都是骗人的。
 */
public class CoinChange {
    /**
     * 可以凑成总金额所需的最少的硬币个数.f(n).
     */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;

            //假设计算到amount.脑海里执行代码。
            //算法框架。算法模板。调整细节。
            for (int i = 1; i <= amount; i++) {
                int max = Integer.MAX_VALUE;
                for (int j : coins) {
                    if (i >= j && dp[i - j] != Integer.MAX_VALUE) {
                        max = Math.min(max, dp[i - j] + 1);
                    }
                }
                dp[i] = max;
            }

            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
