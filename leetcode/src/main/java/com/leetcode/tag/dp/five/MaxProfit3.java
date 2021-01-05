package com.leetcode.tag.dp.five;

/**
 * 188. 买卖股票的最佳时机 IV
 */
public class MaxProfit3 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            k = Math.min(k, prices.length / 2);
            int[][][] dp = new int[prices.length][2][k + 1];
            dp[0][1][0] = -prices[0];
            for (int i = 1; i <= k; i++) {
                dp[0][0][i] = dp[0][1][i] = Integer.MIN_VALUE / 2;
            }

            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0][0] = dp[i - 1][0][0];
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
                for (int j = 1; j <= k; j++) {
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);

                    max = Math.max(max, dp[i][0][j]);
                }
            }

            return max;
        }
    }
}
