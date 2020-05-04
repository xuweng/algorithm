package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 */
public class JumpGame {
  int[] memo;

  public int jump(int[] nums) {
    memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return re(nums, nums.length - 1);
  }

  /**
   * 小数据规模验证
   *
   * <p>小数据规模验证
   *
   * <p>小数据规模验证
   *
   * <p>小数据规模验证
   *
   * <p>最少的跳跃次数到达数组的n位置
   *
   * @param nums
   * @param n    下标
   * @return 最少的跳跃次数到达数组的n位置
   */
  public int re(int[] nums, int n) {
    if (memo[n] != -1) {
      return memo[n];
    }
    // 一个数
    if (n <= 0) {
      memo[n] = 0;
      return 0;
    }
    // 初始化错误?
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= n - 1; i++) {
      if (n - i <= nums[i]) {
        min = Math.min(min, re(nums, i));
      }
    }
    // 假设你总是可以到达数组的最后一个位置
    // 最后跳一步
    memo[n] = min + 1;
    return memo[n];
  }
}
