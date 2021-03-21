package com.leetcode.tag.dp.one.three;

import java.util.HashSet;
import java.util.Set;

/**
 * 983. 最低票价
 * <p>
 * 模型 模型 模型 模型
 * <p>
 * 遍历顺序 初始化
 */
public class MincostTickets {
    /**
     * 方法一：记忆化搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/zui-di-piao-jie-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int[] costs;
        Integer[] memo;
        Set<Integer> dayset;

        public int mincostTickets(int[] days, int[] costs) {
            this.costs = costs;
            memo = new Integer[366];
            dayset = new HashSet<>();
            for (int d : days) {
                dayset.add(d);
            }

            return dp(1);
        }

        public int dp(int i) {
            if (i > 365) {
                return 0;
            }
            if (memo[i] != null) {
                return memo[i];
            }
            // 对于一年中的任意一天
            if (dayset.contains(i)) {
                // 如果这一天是必须出行的日期，我们可以选择买 1，7 或 30 天的通行证。
                // 若我们购买了 j 天的通行证，那么接下来的 j−1 天，我们都不再需要购买通行证，只需要考虑第 i+j 天及以后即可
                // j∈{1,7,30}
                memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
            } else {
                // 如果这一天不是必须出行的日期，那我们可以贪心地选择不买。
                // 这是因为如果今天不用出行，那么也不必购买通行证，并且通行证越晚买越好。
                // 所以有dp(i) = dp(i+1)；
                memo[i] = dp(i + 1);
            }

            return memo[i];
        }
    }

}
