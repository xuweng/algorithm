package com.leetcode.tag.must2.eight;

/**
 * 剑指 Offer 63. 股票的最大利润
 * <p>
 * 溢出 溢出 溢出
 * <p>
 * 负数取模 负数取模 负数取模
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;
            int max = 0;

            for (int i = prices.length - 1; i >= 0; i--) {
                max = Math.max(max, prices[i]);

                result = Math.max(result, max - prices[i]);
            }

            return result;
        }
    }
}
