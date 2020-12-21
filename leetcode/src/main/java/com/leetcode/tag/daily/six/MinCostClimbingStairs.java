package com.leetcode.tag.daily.six;

/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    class Solution {
        int[] meno;

        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) {
                return 0;
            }
            meno = new int[cost.length];

            return back(cost, 0);
        }

        private int back(int[] cost, int start) {
            if (start == 0 || start == 1) {
                return cost[start];
            }
            if (meno[start] != 0) {
                return meno[start];
            }
            int b = Math.min(back(cost, start - 1), back(cost, start - 2));
            meno[start] = b;
            return meno[start];
        }
    }
}
