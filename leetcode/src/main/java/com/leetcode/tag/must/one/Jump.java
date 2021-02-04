package com.leetcode.tag.must.one;

/**
 * 45. 跳跃游戏 II
 */
public class Jump {
    class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (dp[j] != Integer.MAX_VALUE && nums[j] >= i - j) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }
}
