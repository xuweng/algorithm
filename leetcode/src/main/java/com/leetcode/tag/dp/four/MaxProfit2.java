package com.leetcode.tag.dp.four;

/**
 * 188. 买卖股票的最佳时机 IV
 */
public class MaxProfit2 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            k = Math.min(k, n / 2);
            int[][][] dp = new int[n][2][k + 1];
            dp[0][1][0] = -prices[0];
            for (int i = 1; i <= k; i++) {
                dp[0][0][i] = dp[0][1][i] = Integer.MIN_VALUE / 2;
            }

            int max = 0;
            for (int i = 1; i < n; i++) {
                // 没有股票
                dp[i][0][0] = dp[i - 1][0][0];
                // 有股票
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
                // 交易次数从1开始计算.上面对交易次数为0初始化
                for (int j = 1; j <= k; j++) {
                    // 没有股票
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
                    // 有股票
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
                    // 最大利润是没有股票
                    max = Math.max(max, dp[i][0][j]);
                }
            }

            return max;
        }
    }
}
