package com.leetcode.tag.must.two;

import java.util.Arrays;

/**
 * 787. K 站中转内最便宜的航班
 */
public class FindCheapestPrice {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            if (flights == null || flights.length == 0) {
                return -1;
            }
            int[][] dp = new int[n][K + 1];
            for (int[] flight : flights) {
                if (flight[0] == src) {
                    dp[flight[1]][0] = flight[2];
                    continue;
                }
                Arrays.fill(flight, Integer.MAX_VALUE);
            }
            for (int i = 1; i <= K; i++) {
                for (int[] flight : flights) {
                    if (dp[flight[0]][i - 1] != Integer.MAX_VALUE) {
                        dp[flight[1]][i] = Math.min(dp[flight[1]][i], dp[flight[0]][i - 1] + flight[2]);
                    }
                }
            }

            return dp[dst][K] == Integer.MAX_VALUE ? -1 : dp[dst][K];
        }
    }
}
