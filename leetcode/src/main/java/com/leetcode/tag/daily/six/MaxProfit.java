package com.leetcode.tag.daily.six;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            // 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
            int[][] dp = new int[prices.length][2];
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[dp.length - 1][0];
        }
    }
}
