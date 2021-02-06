package com.leetcode.tag.dp.one.one;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 */
public class LengthOfLIS {
  class Solution {
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

  class Solution1 {
    public int lengthOfLIS(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      if (nums.length == 1) {
        return 1;
      }
      // 维护一个上升序列
      int[] max = new int[nums.length];
      max[0] = nums[0];
      int length = 1;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] > max[length - 1]) {
          max[length++] = nums[i];
        } else {
          int index = binarySearch(max, nums[i], 0, length - 1);
          max[index] = nums[i];
        }
      }

      return length;
    }

    public int binarySearch(int[] max, int value, int start, int end) {
      int low = start;
      int high = end;

      while (low < high) {
        int mid = (low + high) >> 1;
        if (value > max[mid]) {
          low = mid + 1;
        } else {
          high = mid;
        }
      }

      return low;
    }
  }
}
