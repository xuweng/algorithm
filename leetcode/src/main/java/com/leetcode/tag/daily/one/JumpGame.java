package com.leetcode.tag.daily.one;

import java.util.Arrays;

/**
 * 递归和dp更加简单,两者写成公式直接求解更加简单;贪心需要处理很多细节
 *
 * <p>45. 跳跃游戏 II
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
   * @param n 下标
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
      // 扫描所有子问题
      if (n - i <= nums[i]) {
        min = Math.min(min, re(nums, i));
      }
    }
    // 假设你总是可以到达数组的最后一个位置
    // 最后跳一步
    memo[n] = min + 1;
    return memo[n];
  }

  public int dp(int[] nums) {
    int[] dp = new int[nums.length];

    dp[0] = 0;
    for (int i = 1; i < nums.length; i++) {
      int min = Integer.MAX_VALUE;
      dp[i] = Integer.MAX_VALUE;
      for (int j = 0; j <= i - 1; j++) {
        // 扫描所有子问题
        if (i - j <= nums[j]) {
          min = Math.min(min, dp[j]);
        }
      }
      dp[i] = min + 1;
    }

    return dp[dp.length - 1];
  }

  /**
   * 贪心
   *
   * @param nums
   * @return
   */
  public int tan(int[] nums) {
    int length = nums.length;
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < length - 1; i++) {
      maxPosition = Math.max(maxPosition, i + nums[i]);
      if (i == end) {
        end = maxPosition;
        steps++;
      }
    }
    return steps;
  }

  public int jump2(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int start = 1;
    int times = 1;
    int max = nums[0];
    while (max < nums.length - 1) {
      int temp = max;
      // temp越界?
      for (int j = start; j <= temp; j++) {
        // 改变max,直接跳到最大值
        max = Math.max(max, nums[j] + j);
      }
      start = temp + 1;
      times++;
    }
    return times;
  }
}
