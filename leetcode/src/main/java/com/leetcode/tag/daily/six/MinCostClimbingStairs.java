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
}
