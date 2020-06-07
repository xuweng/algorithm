package com.leetcode.tag.contest;

/**
 * 5428. 重新排列数组
 */
public class Shuffle {
  class Solution {
    public int[] shuffle(int[] nums, int n) {
      if (nums == null || nums.length == 0) {
        return new int[0];
      }
      int[] left = new int[n];
      int[] right = new int[n];
      for (int i = 0; i < n; i++) {
        left[i] = nums[i];
      }
      int index = 0;
      for (int i = n; i < nums.length; i++) {
        right[index++] = nums[i];
      }
      int[] result = new int[2 * n];
      int curIndex = 0;
      for (int i = 0; i < n; i++) {
        result[curIndex] = left[i];
        result[++curIndex] = right[i];
        ++curIndex;
      }
      return result;
    }
  }
}
