package com.leetcode.tag.daily.four;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int result = 0;
            int pre = 0;
            int i = 0;
            while (i < prices.length) {
                while (pre + 1 < prices.length && prices[pre] > prices[pre + 1]) {
                    pre++;
                }
                int j = pre;
                while (j + 1 < prices.length && prices[j] < prices[j + 1]) {
                    j++;
                }
                if (pre < prices.length && j < prices.length) {
                    result += prices[j] - prices[pre];
                }
                i = j + 1;
                pre = i;
            }
            return result;
        }
    }
}
