package com.leetcode.tag.daily;

/**
 * 560. 和为K的子数组
 */
public class SubarraySum {
  /**
   * 方法一：枚举
   *
   * <p>优化枚举
   *
   * <p>优化枚举
   *
   * <p>优化枚举
   *
   * <p>优化枚举
   *
   * <p>只会枚举没有用
   *
   * <p>只会枚举没有用
   *
   * @param nums
   * @param k
   * @return
   */
  public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) {
          count++;
        }
      }
    }
    return count;
  }
}
