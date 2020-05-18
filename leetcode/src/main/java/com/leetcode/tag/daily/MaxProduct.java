package com.leetcode.tag.daily;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
  /**
   * 找出数组中乘积最大的连续子数组
   *
   * @param nums
   * @return
   */
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = dp[i - 1] <= 0 ? nums[i] : dp[i - 1] * nums[i];
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}
