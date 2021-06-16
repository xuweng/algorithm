package com.leetcode.tag.must6.six;

/**
 * 55. 跳跃游戏
 */
public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;

            for (int i = 1; i < nums.length; i++) {
                for (int j = i; j > 0; j--) {
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
