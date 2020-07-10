package com.leetcode.tag.dp.stock;

/**
 * 股票类型的题目
 * <p>
 * 搞懂题目
 * <p>
 * 搞懂题目
 * <p>
 * 搞懂题目
 * <p>
 * 搞懂题目
 * <p>
 * 推理
 * <p>
 * 决策
 * <p>
 * 推理
 * <p>
 * 决策
 * <p>
 * 推理
 * <p>
 * 决策
 */
public class Stock1 {
    /**
     * 一种常用的方法是将「买入」和「卖出」分开进行考虑：「买入」为负收益，而「卖出」为正收益
     * <p>
     * 我们用 f[i] 表示第 i 天结束之后的「累计最大收益」。根据题目描述，由于我们最多只能同时买入（持有）一支股票，
     * <p>
     * 并且卖出股票后有冷冻期的限制，因此我们会有三种不同的状态：
     * <p>
     * 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]；
     * <p>
     * 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]；
     * <p>
     * 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]。
     * <p>
     * 状态转移?
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            // f[i][0]: 手上持有股票的最大收益
            // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
            // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
            int[][] f = new int[n][3];
            f[0][0] = -prices[0];
            for (int i = 1; i < n; ++i) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
                f[i][1] = f[i - 1][0] + prices[i];
                f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
            }
            return Math.max(f[n - 1][1], f[n - 1][2]);
        }
    }

}
