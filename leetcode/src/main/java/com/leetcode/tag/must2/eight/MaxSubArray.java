package com.leetcode.tag.must2.eight;

/**
 * 53. 最大子序和
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], 0) + nums[i];

                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    class Solution1 {
        public int maxSubArray(int[] nums) {
            int pre = nums[0];
            int cur;
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                cur = Math.max(pre, 0) + nums[i];
                pre = cur;

                max = cur;
            }

            return max;
        }
    }
}
