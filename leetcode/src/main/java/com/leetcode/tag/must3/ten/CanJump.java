package com.leetcode.tag.must3.ten;

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

    class Solution1 {
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length && i <= max; i++) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }

            return false;
        }
    }
}
