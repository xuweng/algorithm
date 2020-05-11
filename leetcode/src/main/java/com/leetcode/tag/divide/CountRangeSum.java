package com.leetcode.tag.divide;

/**
 * 327. 区间和的个数
 */
public class CountRangeSum {
  /**
   * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
   *
   * <p>优化内循环?
   *
   * @param nums
   * @param lower
   * @param upper
   * @return
   */
  public int countRangeSum(int[] nums, int lower, int upper) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      long sum = 0;
      for (int j = i; j < nums.length; j++) {
        // 相加会导致大数溢出
        // 相乘会导致大数溢出
        sum += nums[j];
        if (sum >= lower && sum <= upper) {
          count++;
        }
      }
    }
    return count;
  }
}
