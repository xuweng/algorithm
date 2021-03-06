package com.leetcode.tag.must.two;

/**
 * 486. 预测赢家
 */
public class PredictTheWinner {
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int[][] dp = new int[nums.length][nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = i; j < nums.length; j++) {
                    if (i == j) {
                        dp[i][j] = nums[i];
                    } else {
                        dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                    }
                }
            }

            return dp[0][nums.length - 1] >= 0;
        }
    }

    /**
     * 只依赖两个状态 二维 一维
     */
    class Solution1 {
        public boolean PredictTheWinner(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int[] dp = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = i; j < nums.length; j++) {
                    if (i == j) {
                        dp[i] = nums[i];
                    } else {
                        dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                    }
                }
            }

            return dp[nums.length - 1] >= 0;
        }
    }
}
