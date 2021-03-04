package com.leetcode.tag.must.two;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][] dp = new int[prices.length][3];
            // 有股票
            dp[0][0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                // 有股票
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                // 没有股票 冷冻期
                dp[i][1] = dp[i - 1][0] + prices[i];
                // 没有股票 不是冷冻期
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            }

            return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][2]);
        }
    }
}
