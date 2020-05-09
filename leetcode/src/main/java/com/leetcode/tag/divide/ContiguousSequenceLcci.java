package com.leetcode.tag.divide;

/**
 * 面试题 16.17. 连续数列
 */
public class ContiguousSequenceLcci {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }

    // dp数组
    int[] dp = new int[nums.length];
    // 初始化
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = (dp[i - 1] <= 0) ? nums[i] : dp[i - 1] + nums[i];
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}
