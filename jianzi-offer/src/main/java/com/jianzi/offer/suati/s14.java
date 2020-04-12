package com.jianzi.offer.suati;

/**
 * 面试题14- I. 剪绳子
 */
public class s14 {
  /**
   * 每次将一段绳子剪成两段时，剩下的部分可以继续剪,也可以不剪;
   *
   * <p>从j开始剪下，左部分是j,右部分是i-j
   *
   * @param n
   * @return
   */
  public int cuttingRope(int n) {
    int[] dpMax = new int[n + 1];
    dpMax[0] = 1;
    dpMax[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i - 1; j++) {
        dpMax[i] = Math.max(dpMax[i], Math.max(j * (i - j), dpMax[j] * (i - j)));
      }
    }

    return dpMax[n];
  }
}
