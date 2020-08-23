package com.leetcode.tag.daily.one;

/**
 * 方法一：动态规划
 *
 * <p>有模板。有模板。有模板。有模板
 *
 * <p>837. 新21点
 */
public class New21Game {
  public double new21Game(int N, int K, int W) {
    return 0;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/new-21-game/solution/xin-21dian-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public double new21Game(int N, int K, int W) {
      if (K == 0) {
        return 1.0;
      }
      double[] dp = new double[K + W];
      for (int i = K; i <= N && i < K + W; i++) {
        dp[i] = 1.0;
      }
      for (int i = K - 1; i >= 0; i--) {
        for (int j = 1; j <= W; j++) {
          dp[i] += dp[i + j] / W;
        }
      }
      return dp[0];
    }
  }

  class Solution1 {
    public double new21Game(int N, int K, int W) {
      if (K == 0) {
        return 1.0;
      }
      double[] dp = new double[K + W];
      for (int i = K; i <= N && i < K + W; i++) {
        dp[i] = 1.0;
      }
      dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
      for (int i = K - 2; i >= 0; i--) {
        dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
      }
      return dp[0];
    }
  }
}
