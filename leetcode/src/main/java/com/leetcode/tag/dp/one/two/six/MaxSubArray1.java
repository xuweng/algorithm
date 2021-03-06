package com.leetcode.tag.dp.one.two.six;

/**
 * 53. 最大子序和
 * <p>
 * 子数组 子串 连续 一重循环
 * 子序列 不连续 两重循环
 */
public class MaxSubArray1 {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
}
