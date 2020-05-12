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

  public int divide(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    return re(nums, 0, nums.length - 1);
  }

  private int re(int[] nums, int low, int high) {
    if (low > high) {
      return 0;
    }
    if (low == high) {
      return nums[low];
    }
    int mid = low + (high - low) / 2;
    int leftMax = re(nums, low, mid);
    int rightMax = re(nums, mid + 1, high);

    int lSum = 0;
    int lMax = Integer.MIN_VALUE;
    for (int i = mid; i >= low; i--) {
      lSum += nums[i];
      lMax = Math.max(lMax, lSum);
    }
    int rSum = 0;
    int rMax = Integer.MIN_VALUE;
    for (int i = mid + 1; i <= high; i++) {
      rSum += nums[i];
      rMax = Math.max(rMax, rSum);
    }

    return Math.max(Math.max(leftMax, rightMax), lMax + rMax);
  }
}
