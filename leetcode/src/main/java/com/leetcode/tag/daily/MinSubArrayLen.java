package com.leetcode.tag.daily;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] preSum = new int[nums.length];
    preSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      preSum[i] = preSum[i - 1] + nums[i];
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < preSum.length; i++) {
      int sum = 0;
      for (int j = i; j < preSum.length; j++) {
        if (i == 0) {
          sum = preSum[j];
        } else {
          sum += preSum[j] - preSum[i] + nums[i];
        }
        if (sum >= s) {
          result = Math.min(result, j - i + 1);
          break;
        }
      }
    }
    return (result == Integer.MAX_VALUE) ? 0 : result;
  }
}
