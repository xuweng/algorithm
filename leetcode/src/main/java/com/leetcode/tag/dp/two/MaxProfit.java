package com.leetcode.tag.dp.two;

/**
 * 123. 买卖股票的最佳时机 III
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][][] dp = new int[prices.length][3][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = -prices[0];
            dp[0][1][0] = 0;
            dp[0][1][1] = -prices[0];
            dp[0][2][0] = 0;
            dp[0][2][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp[i][0][0] = dp[i - 1][0][0];
                dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);

                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);

                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
            }

            return Math.max(Math.max(dp[dp.length - 1][0][0], dp[dp.length - 1][1][0]), dp[dp.length - 1][2][0]);
        }
    }
}
