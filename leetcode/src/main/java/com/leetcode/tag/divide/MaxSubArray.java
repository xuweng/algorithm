package com.leetcode.tag.divide;

/**
 * 面试题42. 连续子数组的最大和
 */
public class MaxSubArray {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = dp[i - 1] <= 0 ? nums[i] : dp[i - 1] + nums[i];
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
