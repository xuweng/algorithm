package com.leetcode.tag.dp;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 *
 * <p>不知道有哪些子问题就枚举所有子问题
 */
public class s300 {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    int[] maxDp = new int[nums.length];
    maxDp[0] = 1;
    for (int i = 1; i <= nums.length - 1; i++) {
      maxDp[i] = 1;
      for (int j = 0; j <= i - 1; j++) {
        if (nums[i] > nums[j]) {
          maxDp[i] = Math.max(maxDp[i], maxDp[j] + 1);
        }
      }
    }

    return Arrays.stream(maxDp).max().getAsInt();
  }
}
