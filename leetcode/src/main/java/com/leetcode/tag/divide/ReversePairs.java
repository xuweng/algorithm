package com.leetcode.tag.divide;

/**
 * 没有思路看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>常规分治
 *
 * <p>常规思路
 *
 * <p>子问题依赖
 *
 * <p>算法正确性
 *
 * <p>算法正确性
 *
 * <p>证明算法正确性
 *
 * <p>答案正确性
 *
 * <p>493. 翻转对
 */
public class ReversePairs {
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        long n1 = nums[i];
        // 加和乘导致大数溢出
        long n2 = 2 * nums[j];
        if (n2 < Integer.MAX_VALUE && n1 > n2) {
          count++;
        }
      }
    }
    return count;
  }
}
