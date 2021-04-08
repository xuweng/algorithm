package com.leetcode.tag.must.one.five;

/**
 * 983. 最低票价
 * <p>
 * 正序 倒序 次数
 */
public class MincostTickets {
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int min = days[0];
            int max = days[days.length - 1];
            int index = days.length - 1;

            int[] dp = new int[max + 31];
            for (int i = max; i >= min; i--) {
                if (i == days[index]) {
                    int m = Math.min(dp[i + 1] + costs[0], dp[i + 7] + costs[1]);
                    dp[i] = Math.min(m, dp[i + 30] + costs[2]);
                    index--;
                } else {
                    dp[i] = dp[i + 1];
                }
            }

            return dp[min];
        }
    }
}
