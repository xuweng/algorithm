package com.leetcode.tag.contest;

import java.util.Arrays;

/**
 * 5453. 所有蚂蚁掉下来前的最后一刻
 */
public class GetLastMoment {
  /**
   * 看似简单。
   *
   * <p>看似简单。
   *
   * <p>看似简单。
   *
   * <p>1 <= n <= 10^4
   *
   * <p>0 <= left.length <= n + 1
   *
   * <p>0 <= left[i] <= n
   *
   * <p>0 <= right.length <= n + 1
   *
   * <p>0 <=right[i] <= n
   *
   * <p>1 <= left.length + right.length <= n + 1
   *
   * @param n
   * @param left
   * @param right
   * @return
   */
  public int getLastMoment(int n, int[] left, int[] right) {
    if (n == 0) {
      return 0;
    }
    if (left == null || left.length == 0) {
      int min = Arrays.stream(right).min().getAsInt();
      return n - min;
    }
    if (right == null || right.length == 0) {
      int min = Arrays.stream(left).min().getAsInt();
      return n - min;
    }

    return 0;
  }
}
