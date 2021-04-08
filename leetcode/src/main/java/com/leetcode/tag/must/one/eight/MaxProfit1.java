package com.leetcode.tag.must.one.eight;

/**
 * 123. 买卖股票的最佳时机 III
 * <p>
 * 尽可能多 结果少
 * <p>
 * 同一组数量越多，分组数量越少
 * <p>
 * 滚动数组 dp定义难理解
 */
public class MaxProfit1 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int k = Math.min(2, prices.length / 2);
            int[][][] dp = new int[prices.length][2][k + 1];
            dp[0][1][0] = -prices[0];

            for (int i = 1; i <= k; i++) {
                // 必须 不合法状态推导不合法状态
                dp[0][0][i] = dp[0][1][i] = Integer.MIN_VALUE / 2;
            }
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                // 必须 dp[i][1][0]在循环没有计算 单独计算
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
