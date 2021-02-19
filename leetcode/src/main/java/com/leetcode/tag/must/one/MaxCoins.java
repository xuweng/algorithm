package com.leetcode.tag.must.one;

/**
 * 312. 戳气球
 */
public class MaxCoins {
    class Solution {
        public int maxCoins(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length + 2;
            int[] nNums = new int[length];
            nNums[0] = 1;
            nNums[length - 1] = 1;
            for (int i = 0; i < nums.length; i++) {
                nNums[i + 1] = nums[i];
            }

            int[][] dp = new int[nNums.length][nNums.length];
            for (int i = nNums.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < nNums.length; j++) {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nNums[i] * nNums[k] * nNums[j]);
                    }
                }
            }

            return dp[0][nNums.length - 1];
        }
    }
}
