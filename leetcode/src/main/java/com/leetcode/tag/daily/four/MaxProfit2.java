package com.leetcode.tag.daily.four;

import java.util.HashMap;
import java.util.Map;

/**
 * 123. 买卖股票的最佳时机 III
 */
public class MaxProfit2 {
    /**
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            return dfs(prices, 0, 0, 0);
        }

        /**
         * 如果状态是是买入:
         * <p>
         * 那么可以保持不动
         * 或者马上卖掉
         * <p>
         * 如果状态是卖出:
         * <p>
         * 可以保持不动(等待更好的股价出现，暂时不买)
         * 或者立马再买一股
         * 同时将count数+1，表示交易过一次了
         *
         * @param prices
         * @param index  下标 用来表示当前是哪一天
         * @param status 用来表示当前状态是买入、还是卖出
         * @param k      交易次数 用来表示交易了几次
         * @return 最大利润
         */
        private int dfs(int[] prices, int index, int status, int k) {
            //递归终止条件，数组执行到头了，或者交易了两次了
            if (index == prices.length || k == 2) {
                return 0;
            }
            //定义三个变量，分别记录[不动]、[买]、[卖]
            int b = 0, c = 0;
            //保持不动
            int a = dfs(prices, index + 1, status, k);
            if (status == 1) {
                // 当前状态为买
                // 递归处理卖的情况，这里需要将k+1，表示执行了一次交易
                b = dfs(prices, index + 1, 0, k + 1) + prices[index];
            } else {
                // 当前状态为卖
                // 递归处理买的情况
                c = dfs(prices, index + 1, 1, k) - prices[index];
            }
            //最终结果就是三个变量中的最大值
            return Math.max(Math.max(a, b), c);
        }
    }

    /**
     * 递归+记忆化
     * <p>
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            //用一个哈希表缓存重复的调用
            Map<Key, Integer> map = new HashMap<>();
            return dfs(map, prices, 0, 0, 0);
        }

        private int dfs(Map<Key, Integer> map, int[] prices, int index, int status, int k) {
            Key key = new Key(index, status, k);
            if (map.containsKey(key)) {
                return map.get(key);
            }
            if (index == prices.length || k == 2) {
                return 0;
            }
            int a, b = 0, c = 0;
            a = dfs(map, prices, index + 1, status, k);
            if (status == 1) {
                b = dfs(map, prices, index + 1, 0, k + 1) + prices[index];
            } else {
                c = dfs(map, prices, index + 1, 1, k) - prices[index];
            }
            map.put(key, Math.max(Math.max(a, b), c));
            return map.get(key);
        }

        //Key对象封装了index、status、交易次数，作为map的key
        private class Key {
            final int index;
            final int status;
            final int k;

            Key(int index, int status, int k) {
                this.index = index;
                this.status = status;
                this.k = k;
            }

            //这里需要实现自定义的equals和hashCode函数
            @Override
            public int hashCode() {
                return this.index + this.status + this.k;
            }

            @Override
            public boolean equals(Object obj) {
                Key other = (Key) obj;
                return index == other.index && status == other.status && k == other.k;
            }
        }
    }

    /**
     * 动态规划
     * <p>
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            //定义三维数组，第i天、交易次数、当前的买卖状态(买或者卖)
            int[][][] dp = new int[n][3][2];
            //初始化第一天，这里的dp[0][2][1]可以不用管，后面也不会用到
            dp[0][0][0] = 0;
            dp[0][0][1] = -prices[0];

            dp[0][1][0] = 0;
            dp[0][1][1] = -prices[0];

            dp[0][2][0] = 0;
            dp[0][2][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                //dp[i][0][0]相当于初始状态，它只能从初始状态转换来
                dp[i][0][0] = dp[i - 1][0][0];
                //处理第一次买入、第一次卖出
                dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
                // 第一次卖出(前一天的交易次数为0)
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
                //处理第二次买入、第二次卖出
                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
                // 第二次卖出(前一天的交易次数为1)
                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
            }
            //返回最大值
            int a = Math.max(dp[n - 1][0][0], dp[n - 1][0][1]);
            int b = Math.max(dp[n - 1][1][0], dp[n - 1][1][1]);
            return Math.max(Math.max(a, b), dp[n - 1][2][0]);
        }
    }

    class Solution3 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][][] dp = new int[prices.length][3][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = -prices[0];

            dp[0][1][0] = 0;
            dp[0][1][1] = -prices[0];

            dp[0][2][0] = 0;
            dp[0][2][1] = -prices[0];

            // 必须在再次购买前出售掉之前的股票(前i-1天有股票,先卖股票,第i天才买股票)
            // 卖股票才算一次交易
            for (int i = 1; i < prices.length; i++) {
                dp[i][0][0] = dp[i - 1][0][0];
                // 买股票不算交易.
                // 卖股票才算交易.
                dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);

                // 前i-1天有股票,没有交易;第i天卖股票,交易次数+1。
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
                // 这样第i天的交易次数为0,不会为1.矛盾.
                // dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);

                // 前i-1天有股票,有1次交易;第i天卖股票,交易次数+1。
                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
            }

            return Math.max(dp[dp.length - 1][0][0], Math.max(dp[dp.length - 1][1][0], dp[dp.length - 1][2][0]));
        }
    }

    class Solution4 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int[][][] dpMax = new int[prices.length][3][2];
            dpMax[0][0][0] = 0;
            dpMax[0][0][1] = -prices[0];
            dpMax[0][1][0] = 0;
            dpMax[0][1][1] = -prices[0];
            dpMax[0][2][0] = 0;
            dpMax[0][2][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dpMax[i][0][0] = dpMax[i - 1][0][0];
                dpMax[i][0][1] = Math.max(dpMax[i - 1][0][1], dpMax[i - 1][0][0] - prices[0]);

                dpMax[i][1][0] = Math.max(dpMax[i - 1][1][0], dpMax[i - 1][0][1] + prices[i]);
                dpMax[i][1][1] = Math.max(dpMax[i - 1][1][1], dpMax[i - 1][1][0] - prices[i]);

                dpMax[i][2][0] = Math.max(dpMax[i - 1][2][0], dpMax[i - 1][1][1] + prices[i]);
                // 前i-1天已经交易2次，第i天不能再买入股票
                // dpMax[i][2][0] = Math.max(dpMax[i - 1][2][0], dpMax[i - 1][2][0] - prices[i]);
            }
            return Math.max(Math.max(dpMax[dpMax.length - 1][0][0], dpMax[dpMax.length - 1][1][0]), dpMax[dpMax.length - 1][2][0]);
        }
    }
}