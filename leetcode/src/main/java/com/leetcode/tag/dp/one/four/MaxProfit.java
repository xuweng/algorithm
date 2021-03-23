package com.leetcode.tag.dp.one.four;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][][] dp = new int[prices.length][2][2];
            dp[0][1][0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                // 冷冻期
                dp[i][0][1] = dp[i - 1][1][0] + prices[i];
                // 不是冷冻期 有股票
                dp[i][1][0] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
                // 不是冷冻期 没有股票
                dp[i][0][0] = dp[i - 1][0][0];
            }

            return Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][0][1]);
        }
    }
}
