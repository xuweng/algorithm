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
}
