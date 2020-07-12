package com.leetcode.tag.daily;

/**
 * 174. 地下城游戏
 */
public class CalculateMinimumHP {
  /**
   * dp貌似可以
   *
   * <p>状态转移
   *
   * <p>尝试dp
   *
   * <p>尝试dp
   */
  class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
      int[][] sum = new int[dungeon.length][dungeon[0].length];
      int[][] dp = new int[dungeon.length][dungeon[0].length];
      sum[0][0] = dungeon[0][0];
      dp[0][0] = dungeon[0][0] <= 0 ? 1 - dungeon[0][0] : 0;
      for (int i = 1; i < dungeon[0].length; i++) {
        sum[0][i] = sum[0][i - 1] + dungeon[0][i];
        dp[0][i] = (sum[0][i] <= 0) ? 1 - sum[0][i] : dp[0][i - 1];
      }
      for (int i = 1; i < dungeon.length; i++) {
        sum[i][0] = sum[i - 1][0] + dungeon[i][0];
        dp[i][0] = (sum[i][0] <= 0) ? 1 - sum[i][0] : dp[i - 1][0];
      }
      for (int i = 1; i < dungeon.length; i++) {
        for (int j = 1; j < dungeon[0].length; j++) {
          sum[i][j] = Math.max(sum[i - 1][j], sum[i][j - 1]) + dungeon[i][j];
          dp[i][j] = (sum[i][j] <= 0) ? 1 - sum[i][j] : Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
      }

      return dp[dungeon.length - 1][dungeon[0].length - 1];
    }
  }
}
