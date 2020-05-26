package com.leetcode.tag.backtracking;

/**
 * 1240. 铺瓷砖
 */
public class TilingRectangle {
  public int tilingRectangle(int n, int m) {
    int min = Math.min(n, m);
    int reslut = Integer.MAX_VALUE;
    for (int i = 1; i <= min; i++) {
      reslut = Math.min(reslut, backTrack(i, min, Math.max(n, m)));
    }
    return reslut;
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
  public int backTrack(int select, int n, int m) {
    if (n == m) {
      return 1;
    }
    if (n == 0 || m == 0) {
      return 0;
    }
    if (n > m) {
      return backTrack(select, m, n);
    }
    int min = Integer.MAX_VALUE;
    for (int i = select; i <= n; i = i + select) {
      min = Math.min(min, 1 + backTrack(i, i, m - i) + backTrack(i, n - i, m));
    }

    return min;
  }
}
