package com.leetcode.tag.daily.four;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit {
    /**
     * 只计算递增区间
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int result = 0;
            int pre = 0;
            int i = 0;
            while (i < prices.length) {
                while (pre + 1 < prices.length && prices[pre] > prices[pre + 1]) {
                    pre++;
                }
                int j = pre;
                while (j + 1 < prices.length && prices[j] < prices[j + 1]) {
                    j++;
                }
                if (pre < prices.length && j < prices.length) {
                    result += prices[j] - prices[pre];
                }
                i = j + 1;
                pre = i;
            }
            return result;
        }
    }

    class Solution1 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][] dpMax = new int[prices.length][2];
            dpMax[0][0] = 0;
            dpMax[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1] + prices[i]);
                dpMax[i][1] = Math.max(dpMax[i - 1][0] - prices[i], dpMax[i - 1][1]);
            }
            return Math.max(dpMax[prices.length - 1][0], dpMax[prices.length - 1][1]);
        }
    }

    /**
     * 方法一：动态规划
     * <p>
     * 第i天有1股票,第i+1天有1股票(不卖股票)或者没有股票(卖股票)
     * <p>
     * 第i天有0股票,第i+1天有1股票(买股票)或者没有股票(不买股票)
     * <p>
     * 考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
     * <p>
     * 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
     * <p>
     * dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            // 由于全部交易结束后，持有股票的收益一定低于不持有股票的收益
            // 因此这时候 dp[n−1][0] 的收益必然是大于dp[n−1][1] 的，最后的答案即为 dp[n−1][0]
            return dp[n - 1][0];
        }
    }

    /**
     * 滚动数组
     * <p>
     * 每一天的状态只与前一天的状态有关，而与更早的状态都无关，因此我们不必存储这些无关的状态
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // 只保留前一天
            // 没股票
            int dp0 = 0;
            // 有股票
            int dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int newDp0 = Math.max(dp0, dp1 + prices[i]);
                int newDp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = newDp0;
                dp1 = newDp1;
            }
            return dp0;
        }
    }

    /**
     * 方法二：贪心
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution4 {
        public int maxProfit(int[] prices) {
            int ans = 0;
            int n = prices.length;
            for (int i = 1; i < n; ++i) {
                // 这个计算厉害.负数转为0.
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
    }

    class Solution5 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][] dpMax = new int[prices.length][2];
            dpMax[0][0] = 0;
            dpMax[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1] + prices[i]);
                dpMax[i][1] = Math.max(dpMax[i - 1][0] - prices[i], dpMax[i - 1][1]);
            }
            return dpMax[dpMax.length - 1][0];
        }
    }

}
