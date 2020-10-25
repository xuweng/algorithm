package com.leetcode.tag.contest.one;

import java.util.Arrays;

/**
 * 5424. 数组中两元素的最大乘积
 */
public class MaxProduct {
  public int maxProduct(int[] nums) {
    Arrays.sort(nums);

    return (nums[nums.length - 2] - 1) * (nums[nums.length - 1] - 1);
  }
}
