package com.leetcode.tag.divide;

import java.util.stream.IntStream;

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

  /**
   * 理解错误
   *
   * @param nums
   * @param low
   * @param high
   * @return
   */
  private int re(int[] nums, int low, int high) {
    if (low > high) {
      return 0;
    }
    if (low == high) {
      return nums[low];
    }
    int mid = low + (high - low) / 2;
    int left = re(nums, low, mid);
    int right = re(nums, mid + 1, high);

    int l = IntStream.rangeClosed(low, mid).map(i -> nums[i]).sum();
    int r = IntStream.rangeClosed(mid + 1, high).map(i -> nums[i]).sum();

    return Math.max(Math.max(left, right), l + r);
  }
}
