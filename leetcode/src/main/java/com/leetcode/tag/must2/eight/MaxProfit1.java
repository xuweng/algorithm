package com.leetcode.tag.must2.eight;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 单调递减栈 单调递减栈
 * <p>
 * 单调递增栈 单调递增栈
 */
public class MaxProfit1 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）
            int[][] dp = new int[n][2];
            // 持有一支股票的最大利润
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                // 没有股票
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 有股票
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }
}
