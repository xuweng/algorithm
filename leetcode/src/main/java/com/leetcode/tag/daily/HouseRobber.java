package com.leetcode.tag.daily;

public class HouseRobber {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = i >= 2 ? Math.max(dp[i - 1], dp[i - 2] + nums[i]) : Math.max(nums[i], dp[i - 1]);
    }
    return dp[dp.length - 1];
  }
}
