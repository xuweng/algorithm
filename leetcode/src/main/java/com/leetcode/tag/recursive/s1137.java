package com.leetcode.tag.recursive;

import java.util.Arrays;

/**
 * 1137. 第 N 个泰波那契数
 */
public class s1137 {
  public int tribonacci(int n) {
    int[] me = new int[n + 1];
    Arrays.fill(me, -1);

    return re(n, me);
  }

  public int re(int n, int[] me) {
    if (me[n] != -1) {
      return me[n];
    }
    if (n <= 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }

    me[n] = re(n - 1, me) + re(n - 2, me) + re(n - 3, me);

    return me[n];
  }
}
