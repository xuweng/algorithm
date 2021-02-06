package com.leetcode.tag.dp.one.two.four;

/**
 * 188. 买卖股票的最佳时机 IV
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
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

    /**
     * 作者：lippon
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/java-dong-tai-gui-hua-qing-xi-jian-ming-ot6n0/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if (n == 0) {
                return 0;
            }

            // 如果k超过了最大可买卖次数，那就将k置为最大买卖次数
            // 最大买卖次数就是天数的一半，如果当前卖出又买入，是没有意义的
            k = Math.min(k, n / 2);

            // 状态表示数组，三个维度分别代表：第几天，手上是否有股票0没有1有，还剩下多少次买卖机会
            // 数组值表示当前还有多少钱
            int[][][] f = new int[n][2][k + 1];

            // 设置初始值，第一天手上有股票的状态，就是买入第一天价格的值
            for (int i = 0; i <= k; i++) {
                f[0][1][i] = -prices[0];
            }
            // 状态转移，遍历天数
            for (int i = 1; i < n; i++) {
                // 枚举当天所有可能买卖次数的状态
                for (int j = 1; j <= k; j++) {
                    // 当前不持有股票的状态转移
                    if (j < k) {
                        // 当前不持有股票，要么前一天也没有股票，要么前一天有股票但是今天卖出了
                        // 如果今天卖出的话，买卖次数就会比前一天少一次，当天是j，那么前一天就是j+1
                        f[i][0][j] = Math.max(f[i - 1][0][j], f[i - 1][1][j + 1] + prices[i]);
                    } else {
                        // 剩余买卖次数j等于初始值剩余交易次数k的时候，那么说明从来没有产生过交易，所以需要从前一天的不持有状态转移过来
                        f[i][0][j] = f[i - 1][0][j];
                    }

                    // 当前持有股票的状态转移，要么前一天也有股票，要么前一天不持有股票但是当天买入了股票
                    f[i][1][j] = Math.max(f[i - 1][1][j], f[i - 1][0][j] - prices[i]);
                }
            }

            int res = 0;
            // 获取最大值，最大值肯定出现在当前手上不持有股票的状态
            for (int i = 0; i <= k; i++) {
                res = Math.max(res, f[n - 1][0][i]);
            }

            return res;

        }
    }

}
