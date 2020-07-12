package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>174. 地下城游戏
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

  /**
   * 方法一：动态规划
   */
  class Solution1 {
    /**
     * 方法一：动态规划 思路及算法
     *
     * <p>几个要素：「M×N 的网格」「每次只能向右或者向下移动一步」。让人很容易想到该题使用动态规划的方法。
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
      int n = dungeon.length, m = dungeon[0].length;
      int[][] dp = new int[n + 1][m + 1];
      for (int i = 0; i <= n; ++i) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
      }
      dp[n][m - 1] = dp[n - 1][m] = 1;
      for (int i = n - 1; i >= 0; --i) {
        for (int j = m - 1; j >= 0; --j) {
          int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
          dp[i][j] = Math.max(minn - dungeon[i][j], 1);
        }
      }
      return dp[0][0];
    }
  }
}
