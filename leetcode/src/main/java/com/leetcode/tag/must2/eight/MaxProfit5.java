package com.leetcode.tag.must2.eight;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class MaxProfit5 {
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][3];
            // 有股票
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                // 冷冻期 没有股票
                dp[i][0] = dp[i - 1][1] + prices[i];
                // 不是冷冻期 有股票
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
                // 不是冷冻期 没有股票
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0]);
            }

            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
        }
    }

    /**
     * 滚动数组
     */
    class Solution1 {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            int f0 = 0;
            // 有股票
            int f1 = -prices[0];
            int f2 = 0;
            for (int i = 1; i < n; ++i) {
                // 冷冻期 没有股票
                int newf0 = f1 + prices[i];
                // 不是冷冻期 有股票
                int newf1 = Math.max(f1, f2 - prices[i]);
                // 不是冷冻期 没有股票
                int newf2 = Math.max(f2, f0);

                f0 = newf0;
                f1 = newf1;
                f2 = newf2;
            }

            return Math.max(f0, f2);
        }
    }
}
