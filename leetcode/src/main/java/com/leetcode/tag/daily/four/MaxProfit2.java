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

}
