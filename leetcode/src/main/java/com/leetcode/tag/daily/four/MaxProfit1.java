package com.leetcode.tag.daily.four;

/**
 * 121. 买卖股票的最佳时机
 */
public class MaxProfit1 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    result = Math.max(result, prices[j] - prices[i]);
                }
            }
            return result;
        }
    }
}
