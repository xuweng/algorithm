package com.leetcode.tag.daily;

/**
 * 213. 打家劫舍 II
 */
public class HouseRobber2 {
  /**
   * 这意味着第一个房屋和最后一个房屋是紧挨着的
   *
   * <p>第一个和最后一个不能共存，只能取一个
   *
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length <= 3) {
      return Math.max(nums[0], nums[1]);
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length - 1; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    int max1 = dp[nums.length - 2];

    dp[nums.length - 1] = nums[nums.length - 1];
    dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    for (int i = nums.length - 3; i >= 0; i--) {
      dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
    }
    int max2 = dp[1];

    return Math.max(max1, max2);
  }
}
