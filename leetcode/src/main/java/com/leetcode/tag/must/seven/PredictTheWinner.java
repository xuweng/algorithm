package com.leetcode.tag.must.seven;

/**
 * 486. 预测赢家
 */
public class PredictTheWinner {
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            if (nums == null) {
                return false;
            }
            int[][] dp = new int[nums.length][nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i][i] = nums[i];
            }
            for (int i = nums.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < nums.length; j++) {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }

            return dp[0][dp.length - 1] >= 0;
        }
    }
}
