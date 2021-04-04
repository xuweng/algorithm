package com.leetcode.tag.must.eight;

/**
 * 188. 买卖股票的最佳时机 IV
 * <p>
 * 尽可能多 结果少
 * <p>
 * 同一组数量越多，分组数量越少
 */
public class MaxProfit {
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

    /**
     * 二维
     */
    class Solution2 {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            k = Math.min(k, prices.length / 2);
            int[][] dp = new int[2][k + 1];
            dp[1][0] = -prices[0];

            for (int i = 1; i <= k; i++) {
                dp[0][i] = dp[1][i] = Integer.MIN_VALUE / 2;
            }
            int max = 0;
            for (int price : prices) {
                for (int j = k; j >= 1; j--) {
                    dp[0][j] = Math.max(dp[0][j], dp[1][j - 1] + price);
                    dp[1][j] = Math.max(dp[1][j], dp[0][j] - price);

                    max = Math.max(max, dp[0][j]);
                }
            }

            return max;
        }
    }

    class Solution1 {
        public int maxProfit(int k, int[] prices) {
            int[][] dp = new int[k + 1][2];
            for (int[] i : dp) {
                i[1] = Integer.MIN_VALUE;
            }
            dp[0][1] = 0;
            for (int i : prices) {
                for (int j = k; j > 0; --j) {
                    dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - i);
                    dp[j][0] = Math.max(dp[j][0], dp[j][1] + i);
                }
            }

            int max = 0;
            for (int[] i : dp) {
                max = Math.max(max, i[0]);
            }
            return max;
        }
    }
}
