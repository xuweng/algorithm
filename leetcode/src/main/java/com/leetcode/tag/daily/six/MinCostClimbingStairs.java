package com.leetcode.tag.daily.six;

/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    static class Solution {
        int[] meno1;
        int[] meno2;

        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) {
                return 0;
            }
            meno1 = new int[cost.length];
            meno2 = new int[cost.length];

            return Math.min(back1(cost, 0), back2(cost, 1));
        }

        private int back1(int[] cost, int start) {
            if (start >= cost.length) {
                return 0;
            }
            if (meno1[start] != 0) {
                return meno1[start];
            }
            int result = cost[start] + Math.min(back1(cost, start + 1), back1(cost, start + 2));
            meno1[start] = result;
            return meno1[start];
        }

        private int back2(int[] cost, int start) {
            if (start >= cost.length) {
                return 0;
            }
            if (meno2[start] != 0) {
                return meno2[start];
            }
            int result = cost[start] + Math.min(back2(cost, start + 1), back2(cost, start + 2));
            meno2[start] = result;
            return meno2[start];
        }
    }

    class Solution1 {
        /**
         * 一个缓存就够
         */
        int[] meno;

        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) {
                return 0;
            }
            meno = new int[cost.length];

            return Math.min(back(cost, 0), back(cost, 1));
        }

        /**
         * 表示从start跳到终点
         *
         * @param cost
         * @param start
         * @return
         */
        private int back(int[] cost, int start) {
            if (start >= cost.length) {
                return 0;
            }
            if (meno[start] != 0) {
                return meno[start];
            }
            int result = cost[start] + Math.min(back(cost, start + 1), back(cost, start + 2));
            meno[start] = result;
            return meno[start];
        }

    }

    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/shi-yong-zui-xiao-hua-fei-pa-lou-ti-by-l-ncf8/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            //dp[i] 表示达到下标 i 的最小花费。
            int[] dp = new int[n + 1];
            //可以选择下标 0 或 1 作为初始阶梯
            dp[0] = dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[n];
        }
    }

    /**
     * 注意到当 i≥2 时，dp[i] 只和 dp[i−1] 与 dp[i−2] 有关
     * <p>
     * 因此可以使用滚动数组的思想，将空间复杂度优化到 O(1)。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/shi-yong-zui-xiao-hua-fei-pa-lou-ti-by-l-ncf8/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution4 {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int prev = 0, curr = 0;
            for (int i = 2; i <= n; i++) {
                int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
                prev = curr;
                curr = next;
            }
            return curr;
        }
    }

}
