package com.leetcode.tag.must2.eight;

/**
 * 123. 买卖股票的最佳时机 III
 */
public class MaxProfit2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // 第1次交易
            int buy1 = -prices[0], sell1 = 0;
            // 第二次交易
            int buy2 = -prices[0], sell2 = 0;
            for (int i = 1; i < n; ++i) {
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);

                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }
    }
}
