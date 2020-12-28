package com.leetcode.tag.dp.four;

/**
 * 188. 买卖股票的最佳时机 IV
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            k = Math.min(k, n / 2);

            int[][] buy = new int[n][k + 1];
            int[][] sell = new int[n][k + 1];
            buy[0][0] = -prices[0];
            sell[0][0] = 0;
            for (int i = 1; i <= k; i++) {
                buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
            }

            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
                for (int j = 1; j <= k; j++) {
                    buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                    sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);

                    max = Math.max(max, sell[i][j]);
                }
            }

            return max;
        }
    }
}
