package com.leetcode.tag.must5.three;

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

            int[][] dp = new int[k + 1][2];
            dp[0][1] = -prices[0];
            for (int i = 1; i <= k; i++) {
                dp[i][0] = dp[i][1] = Integer.MIN_VALUE / 2;
            }

            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[0][1] = Math.max(dp[0][1], dp[0][0] - prices[i]);
                for (int j = 1; j <= k; j++) {
                    dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);
                    dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);

                    max = Math.max(max, dp[j][0]);
                }
            }

            return max;
        }
    }
}
