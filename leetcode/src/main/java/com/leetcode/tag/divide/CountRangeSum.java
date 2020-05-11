package com.leetcode.tag.divide;

/**
 * 327. 区间和的个数
 */
public class CountRangeSum {
  public int countRangeSum(int[] nums, int lower, int upper) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      long sum = nums[i];
      if (sum >= lower && sum <= upper) {
        count++;
      }
      for (int j = i + 1; j < nums.length; j++) {
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
