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
}
