package com.leetcode.tag.daily;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
  /**
   * 太多判断
   *
   * <p>递归函数定义错误?
   *
   * <p>状态定义错误?状态方程错误?
   *
   * <p>冗余代码太多
   *
   * <p>冗余代码太多
   *
   * <p>找出数组中乘积最大的连续子数组
   *
   * @param nums
   * @return
   */
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[][] dp = new int[nums.length][2];
    dp[0][0] = nums[0];
    dp[0][1] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == 0) {
        dp[i][0] = 0;
        dp[i][1] = 0;
      } else if (nums[i] < 0) {
        if (dp[i - 1][1] == 0) {
          dp[i][0] = 0;
          dp[i][1] = nums[i];
        } else if (dp[i - 1][1] < 0) {
          dp[i][0] = dp[i - 1][1] * nums[i];
          dp[i][1] = nums[i];
        } else {
          dp[i][0] = nums[i];
          dp[i][1] = dp[i - 1][1] * nums[i];
        }
      } else {
        if (dp[i - 1][1] == 0) {
          dp[i][0] = nums[i];
          dp[i][1] = nums[i];
        } else if (dp[i - 1][1] < 0) {
          dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
          dp[i][1] = dp[i - 1][1] * nums[i];
        } else {
          dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
          dp[i][1] = nums[i];
        }
      }

      max = Math.max(max, dp[i][0]);
    }

    return max;
  }
}
