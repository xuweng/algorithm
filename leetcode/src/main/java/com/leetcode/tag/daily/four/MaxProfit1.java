package com.leetcode.tag.daily.four;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 这个题本质就是要求某个数与其右边最大的数的差值
 * <p>
 * 这符合了单调栈的应用场景 当你需要高效率查询某个位置左右两侧比他大（或小）的数的位置的时候
 */
public class MaxProfit1 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    result = Math.max(result, prices[j] - prices[i]);
                }
            }
            return result;
        }
    }

    /**
     * 方法二：一次遍历
     * <p>
     * 计算每个递增区间.每个递增区间的最大差值.
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxProfit(int prices[]) {
            // 最小值
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int price : prices) {
                if (price < minPrice) {
                    // 更新最小股票
                    minPrice = price;
                } else {
                    // 当前股票大于最小股票
                    maxProfit = Math.max(maxProfit, price - minPrice);
                }
            }
            return maxProfit;
        }
    }

}
