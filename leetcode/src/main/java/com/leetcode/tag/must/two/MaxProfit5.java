package com.leetcode.tag.must.two;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * <p>
 * 状态依赖 状态依赖 状态依赖 状态依赖
 */
public class MaxProfit5 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][][] dp = new int[prices.length][2][2];
            dp[0][1][0] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp[i][0][1] = dp[i - 1][1][0] + prices[i];
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i][0][0] - prices[i]);
                dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
            }

            return Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][0][1]);
        }
    }
}
