package com.leetcode.tag.dp;

/**
 * 55. 跳跃游戏
 */
public class JumpGame {
  /**
   * 熟练dp
   *
   * @param nums
   * @return
   */
  public boolean canJump(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[0] = true;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = false;
      for (int j = 0; j < i; j++) {
        dp[i] = dp[i] || dp[j] && nums[j] >= (i - j);
      }
    }

    return dp[nums.length - 1];
  }

  /**
   * 贪心
   *
   * <p>自己理解
   *
   * <p>理解后算法很简单
   *
   * @param nums
   * @return
   */
  public boolean tan(int[] nums) {
    // 最远位置下标
    int maxIndex = nums[0];
    for (int i = 1; i < nums.length && maxIndex < nums.length - 1; i++) {
      // 从i位置下标最远可以跳到位置
      int index = i + nums[i];
      if (i <= maxIndex && index > maxIndex) {
        maxIndex = index;
      }
    }

    return maxIndex >= nums.length - 1;
  }
}
