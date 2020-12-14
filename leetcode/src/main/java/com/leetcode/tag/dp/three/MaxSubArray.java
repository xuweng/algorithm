package com.leetcode.tag.dp.three;

/**
 * 53. 最大子序和
 * <p>
 * 脑里按照示例跑一遍代码
 * <p>
 * 自己写一遍 自己写一笔 自己写一遍 自己写一遍 自己写一遍 自己写一遍
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i];
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
