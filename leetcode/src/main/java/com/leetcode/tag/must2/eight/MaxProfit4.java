package com.leetcode.tag.must2.eight;

/**
 * 714. 买卖股票的最佳时机含手续费
 * <p>
 * 1次 2次 n次 k次
 * <p>
 * 滚动数组 滚动数组 滚动数组
 */
public class MaxProfit4 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int[][] dp = new int[prices.length][2];
            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }

            return dp[prices.length - 1][0];
        }
    }
}
