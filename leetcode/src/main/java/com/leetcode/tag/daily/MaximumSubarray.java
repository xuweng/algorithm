package com.leetcode.tag.daily;

/**
 * 53. 最大子序和
 */
public class MaximumSubarray {
  /**
   * 暴力法
   *
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }

    int max = nums[nums.length - 1];
    for (int i = 0; i < nums.length - 1; i++) {
      int sum = nums[i];
      max = Math.max(max, sum);
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        max = Math.max(max, sum);
      }
    }

    return max;
  }

  public int dp(int[] nums) {
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

  public int dp2(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }

    // 初始化
    int max = nums[0];
    // 前一个数
    int pre = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int cur = (pre <= 0) ? nums[i] : pre + nums[i];
      pre = cur;
      max = Math.max(max, cur);
    }

    return max;
  }
}
