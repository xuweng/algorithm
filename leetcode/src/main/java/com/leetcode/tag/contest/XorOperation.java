package com.leetcode.tag.contest;

/**
 * 5440. 数组异或操作
 */
public class XorOperation {
  public int xorOperation(int n, int start) {
    int[] nums = new int[n];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = start + 2 * i;
    }
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result = result ^ nums[i];
    }

    return result;
  }
}
