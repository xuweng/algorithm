package com.leetcode.tag.must6.six;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class MaxProfit2 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int buy = -prices[0];
            int sell = 0;

            for (int i = 1; i < prices.length; i++) {
                int b = Math.max(buy, sell - prices[i]);
                int s = Math.max(sell, buy + prices[i] - fee);

                buy = b;
                sell = s;
            }

            return sell;
        }
    }
}
