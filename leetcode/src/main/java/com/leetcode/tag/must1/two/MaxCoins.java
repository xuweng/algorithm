package com.leetcode.tag.must1.two;

/**
 * 312. 戳气球
 */
public class MaxCoins {
    class Solution {
        public int maxCoins(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int[] newNums = new int[nums.length];
            newNums[0] = 1;
            newNums[newNums.length - 1] = 1;

            for (int i = 1; i < newNums.length - 1; i++) {
                newNums[i] = nums[i - 1];
            }

            int[][] dp = new int[newNums.length][newNums.length];
            for (int i = newNums.length - 1; i >= 0; i--) {
                for (int j = i + 1; j < newNums.length; j++) {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                    }
                }
            }

            return dp[0][newNums.length - 1];
        }
    }
}
