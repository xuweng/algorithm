package com.leetcode.tag.must4.six;

/**
 * 312. 戳气球
 */
public class MaxCoins {
    class Solution {
        public int maxCoins(int[] nums) {
            int[] n = new int[nums.length + 2];
            n[0] = 1;
            n[n.length - 1] = 1;

            for (int i = 1; i < n.length - 1; i++) {
                n[i] = nums[i - 1];
            }

            int[][] dp = new int[n.length][n.length];
            for (int i = n.length - 1; i >= 0; i--) {
                for (int j = i + 1; j < n.length; j++) {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + n[i] * n[k] * n[j]);
                    }
                }
            }

            return dp[0][n.length - 1];
        }
    }
}
