package com.leetcode.tag.must3.seven;

/**
 * 55. 跳跃游戏
 */
public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= i - j) {
                        dp[i] = dp[i] || dp[j];
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }
}
