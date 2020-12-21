package com.leetcode.tag.dp.three;

/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) {
                return 0;
            }
            int[] dp = new int[cost.length];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < cost.length; i++) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
            return Math.min(dp[dp.length - 2], dp[dp.length - 1]);
        }
    }
}
