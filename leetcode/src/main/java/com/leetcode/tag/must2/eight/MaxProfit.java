package com.leetcode.tag.must2.eight;

/**
 * 剑指 Offer 63. 股票的最大利润
 * <p>
 * 溢出 溢出 溢出
 * <p>
 * 负数取模 负数取模 负数取模
 */
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;
            int max = 0;

            for (int i = prices.length - 1; i >= 0; i--) {
                max = Math.max(max, prices[i]);

                result = Math.max(result, max - prices[i]);
            }

            return result;
        }
    }

    /**
     * 每天的选择：买股票，卖股票
     * <p>
     * 每天我们都可以选择出售股票与否。那么，假设在第 i 天，如果我们要在今天卖股票，那么我们能赚多少钱呢？
     * <p>
     * 显然，如果我们真的在买卖股票，我们肯定会想：如果我是在历史最低点买的股票就好了！太好了，在题目中，
     * <p>
     * 我们只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。
     * <p>
     * 那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/solution/gu-piao-de-zui-da-li-run-by-leetcode-sol-0l1g/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public class Solution1 {
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int price : prices) {
                if (price < minprice) {
                    minprice = price;
                } else if (price - minprice > maxprofit) {
                    maxprofit = price - minprice;
                }
            }
            return maxprofit;
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            // 最低价格
            int cost = Integer.MAX_VALUE;
            int profit = 0;
            for (int price : prices) {
                cost = Math.min(cost, price);

                profit = Math.max(profit, price - cost);
            }
            return profit;
        }
    }
}
