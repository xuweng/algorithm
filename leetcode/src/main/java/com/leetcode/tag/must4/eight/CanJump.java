package com.leetcode.tag.must4.eight;

/**
 * 55. 跳跃游戏
 */
public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && nums[j] >= i - j) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }
}
