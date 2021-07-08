package com.leetcode.tag.must7.one;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class MaxProfit1 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int buy = -prices[0];
            int sell = 0;

            for (int i = 1; i < prices.length; i++) {
                buy = Math.max(buy, sell - prices[i]);
                sell = Math.max(sell, buy + prices[i] - fee);
            }

            return sell;
        }
    }
}
