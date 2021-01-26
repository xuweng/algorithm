package com.leetcode.tag.must.one;

/**
 * 494. 目标和
 * <p>
 * 状态压缩 二进制
 * <p>
 * 状态压缩 二进制
 */
public class FindTargetSumWays {
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[][] dp = new int[nums.length + 1][S + 1];
            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= S; j++) {
                    int s = 0;
                    if (j >= nums[i - 1]) {
                        s += dp[i - 1][j - nums[i - 1]];
                    } else if (j + nums[i - 1] <= S) {
                        s += dp[i - 1][j + nums[i - 1]];
                    } else {
                        s = dp[i - 1][j];
                    }
                    dp[i][j] = s;
                }
            }

            return dp[nums.length][S];
        }
    }
}
