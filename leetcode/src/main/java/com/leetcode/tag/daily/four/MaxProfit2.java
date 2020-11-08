package com.leetcode.tag.daily.four;

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
         * @param prices
         * @param index  下标
         * @param status
         * @param k      交易次数
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

}
