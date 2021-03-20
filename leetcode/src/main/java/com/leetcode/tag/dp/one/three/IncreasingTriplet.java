package com.leetcode.tag.dp.one.three;

/**
 * 334. 递增的三元子序列
 */
public class IncreasingTriplet {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    if (dp[i] >= 3) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
