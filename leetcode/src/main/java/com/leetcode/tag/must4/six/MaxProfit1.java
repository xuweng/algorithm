package com.leetcode.tag.must4.six;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class MaxProfit1 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int buy = -prices[0];
            int sell = 0;

            for (int i = 1; i < prices.length; i++) {
                int newBuy = Math.max(buy, sell - prices[i]);
                int newSell = Math.max(sell, buy + prices[i] - fee);

                buy = newBuy;
                sell = newSell;
            }

            return sell;
        }
    }
}
