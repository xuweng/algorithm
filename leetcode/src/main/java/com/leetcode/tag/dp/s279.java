package com.leetcode.tag.dp;

/**
 * 279. 完全平方数
 */
public class s279 {
  /**
   * 最后一步
   *
   * <p>写出状态转移方程
   *
   * @param n
   * @return
   */
  public int numSquares(int n) {
    int[] minDp = new int[n + 1];
    minDp[0] = 0;
    minDp[1] = 1;
    for (int i = 2; i <= n; i++) {
      // 初始化最大值
      minDp[i] = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        minDp[i] = Math.min(minDp[i], minDp[i - j * j] + 1);
      }
    }

    return minDp[n];
  }
}
