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

  /**
   * 分治法
   *
   * @param nums
   * @return
   */
  public int fen(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }

    return re(nums, 0, nums.length - 1);
  }

  /**
   * 分治法.
   *
   * <p>划分子问题包含全部,不要漏掉某个子问题
   *
   * <p>3部分:左,右,夸过
   *
   * <p>4部分:左,中间,右,夸过
   *
   * @param nums
   * @param start
   * @param end
   * @return
   */
  private int re(int[] nums, int start, int end) {
    if (start >= end) {
      return nums[start];
    }
    int middle = start + (end - start) / 2;
    // 左
    int left = re(nums, start, middle);
    // 右
    int right = re(nums, middle + 1, end);
    // 夸过middle.需要计算?
    int m = prSum(nums, start, middle) + houSum(nums, middle + 1, end);

    return Math.max(Math.max(left, right), m);
  }

  private int prSum(int[] nums, int start, int end) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = end; i >= start; i--) {
      sum += nums[i];
      max = Math.max(max, sum);
    }
    return max;
  }

  private int houSum(int[] nums, int start, int end) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = start; i <= end; i++) {
      sum += nums[i];
      max = Math.max(max, sum);
    }
    return max;
  }
}
