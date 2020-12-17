package com.leetcode.tag.daily.six;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            // 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
            int[][] dp = new int[prices.length][2];
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[dp.length - 1][0];
        }
    }

    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int sell = 0, buy = -prices[0];
            for (int i = 1; i < n; ++i) {
                sell = Math.max(sell, buy + prices[i] - fee);
                buy = Math.max(buy, sell - prices[i]);
            }
            return sell;
        }
    }

    /**
     * 方法二：贪心算法
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int buy = prices[0] + fee;
            int profit = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] + fee < buy) {
                    buy = prices[i] + fee;
                } else if (prices[i] > buy) {
                    profit += prices[i] - buy;
                    buy = prices[i];
                }
            }
            return profit;
        }
    }

}
