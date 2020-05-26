package com.leetcode.tag.backtracking;

/**
 * 1240. 铺瓷砖
 */
public class TilingRectangle {
  public int tilingRectangle(int n, int m) {
    return backTrack(Math.min(n, m), Math.max(n, m));
  }

  /**
   * 不要漏掉某个子问题
   *
   * <p>重复子问题比漏掉子问题好
   *
   * @param n
   * @param m
   * @return
   */
  public int backTrack(int n, int m) {
    if (n == m) {
      return 1;
    }
    if (n == 0) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      min = Math.min(min, i + backTrack(i, m - 1) + backTrack(n - i, m));
    }

    return min;
  }
}
