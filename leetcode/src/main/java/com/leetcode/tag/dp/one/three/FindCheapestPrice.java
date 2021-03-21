package com.leetcode.tag.dp.one.three;

import java.util.Arrays;

/**
 * 787. K 站中转内最便宜的航班
 * <p>
 * 标记 改变原数组
 */
public class FindCheapestPrice {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            if (flights == null || flights.length == 0) {
                return -1;
            }
            int[][] dp = new int[n][K + 1];
            for (int i = 0; i < dp.length; i++) {
                if (i == src) {
                    continue;
                }
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for (int[] flight : flights) {
                if (flight[0] == src) {
                    // 从src直达flight[1] 不需要换乘
                    dp[flight[1]][0] = flight[2];
                }
            }
            for (int i = 1; i <= K; i++) {
                for (int[] flight : flights) {
                    if (dp[flight[0]][i - 1] != Integer.MAX_VALUE) {
                        // src可以到达flight[0] flight[0]换乘1次到达flight[1]
                        // 可以到达flight[0] 换成1次到达flight[1]
                        dp[flight[1]][i] = Math.min(dp[flight[1]][i], dp[flight[0]][i - 1] + flight[2]);
                    }
                }
            }

            return dp[dst][K] == Integer.MAX_VALUE ? -1 : dp[dst][K];
        }
    }
}
