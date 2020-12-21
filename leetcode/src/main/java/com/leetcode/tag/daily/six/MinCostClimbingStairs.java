package com.leetcode.tag.daily.six;

/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    static class Solution {
        int[] meno;

        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) {
                return 0;
            }
            meno = new int[cost.length];

            return Math.min(back(cost, 0), back(cost, 1));
        }

        private int back(int[] cost, int start) {
            if (start >= cost.length) {
                return 0;
            }
            return cost[start] + Math.min(back(cost, start + 1), back(cost, start + 2));
        }
    }
}
