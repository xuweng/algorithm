package com.leetcode.tag.must2.eight;

/**
 * 188. 买卖股票的最佳时机 IV
 * <p>
 * 1次 2次 n次 k次
 * <p>
 * 溢出 溢出 溢出
 * <p>
 * 负数取模 负数取模 负数取模
 */
public class MaxProfit3 {
    /**
     * 方法一：动态规划
     */
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            // n天最多只能进行 n/2 次交易
            k = Math.min(k, n / 2);
            int[][] buy = new int[n][k + 1];
            int[][] sell = new int[n][k + 1];

            buy[0][0] = -prices[0];
            for (int i = 1; i <= k; ++i) {
                // 设置不合法的状态 不合法状态转移不合法状态
                buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
            }

            int max = 0;
            for (int i = 1; i < n; ++i) {
                buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
                for (int j = 1; j <= k; ++j) {
                    buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                    sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);

                    max = Math.max(max, sell[i][j]);
                }
            }

            return max;
        }
    }

    /**
     * 滚动数组
     */
    class Solution1 {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            k = Math.min(k, n / 2);
            int[] buy = new int[k + 1];
            int[] sell = new int[k + 1];

            buy[0] = -prices[0];
            for (int i = 1; i <= k; ++i) {
                buy[i] = sell[i] = Integer.MIN_VALUE / 2;
            }

            int max = 0;
            for (int i = 1; i < n; ++i) {
                buy[0] = Math.max(buy[0], sell[0] - prices[i]);
                for (int j = 1; j <= k; ++j) {
                    buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                    sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);

                    max = Math.max(max, sell[i]);
                }
            }

            return max;
        }
    }
}
