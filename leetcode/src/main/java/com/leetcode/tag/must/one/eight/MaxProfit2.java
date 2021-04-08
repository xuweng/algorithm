package com.leetcode.tag.must.one.eight;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class MaxProfit2 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][] dp = new int[prices.length][3];
            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                // 冷冻期
                dp[i][0] = dp[i - 1][1] + prices[i];
                // 不是冷冻期 有股票
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
                // 不是冷冻期 没有股票
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0]);
            }

            return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][2]);
        }
    }
}
