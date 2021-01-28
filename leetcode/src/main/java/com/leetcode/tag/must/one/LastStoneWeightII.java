package com.leetcode.tag.must.one;

import java.util.Arrays;

/**
 * 1049. 最后一块石头的重量 II
 */
public class LastStoneWeightII {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            if (stones == null || stones.length == 0) {
                return 0;
            }
            int total = Arrays.stream(stones).sum();
            int sum = total / 2;
            int[][] dp = new int[stones.length + 1][sum + 1];
            for (int i = 1; i <= stones.length; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j < stones[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                    }
                }
            }

            return total - 2 * dp[stones.length][sum];
        }
    }

    class Solution1 {
        public int lastStoneWeightII(int[] stones) {
            if (stones == null || stones.length == 0) {
                return 0;
            }
            int total = Arrays.stream(stones).sum();
            int sum = total / 2;
            int[] dp = new int[sum + 1];
            for (int stone : stones) {
                for (int i = sum; i >= stone; i--) {
                    dp[i] = Math.max(dp[i], dp[i - stone] + stone);
                }
            }

            return total - 2 * dp[sum];
        }
    }
}
