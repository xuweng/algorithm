package com.leetcode.tag.daily;

/**
 * 312. 戳气球
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 */
public class MaxCoins {
  class Solution {
    int[][] me;

    public int maxCoins(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      if (nums.length == 1) {
        return nums[0];
      }
      int newLength = nums.length + 2;
      me = new int[newLength][newLength];

      int[] newNums = new int[newLength];
      // 新数组首和尾都插入1
      newNums[0] = 1;
      newNums[newNums.length - 1] = 1;
      System.arraycopy(nums, 0, newNums, 1, nums.length);
      return re(newNums, 1, newNums.length - 2);
    }

    /**
     * 第low和第high都是不可戳
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public int re(int[] nums, int low, int high) {
      if (me[low][high] != 0) {
        return me[low][high];
      }
      // 递归终止条件
      // 终止条件特别麻烦
      if (high - low <= 1) {
        return 0;
      }
      int max = Integer.MIN_VALUE;
      // i的范围?low<i<high
      for (int i = low; i <= high; i++) {
        max =
                Math.max(max, re(nums, low, i) + re(nums, i, high) + nums[low] * nums[i] * nums[high]);
      }
      me[low][high] = max;
      return max;
    }
  }
}
