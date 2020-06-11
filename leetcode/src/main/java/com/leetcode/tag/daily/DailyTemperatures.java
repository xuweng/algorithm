package com.leetcode.tag.daily;

/**
 * 739. 每日温度
 */
public class DailyTemperatures {
  public int[] dailyTemperatures(int[] T) {
    if (T == null || T.length == 0) {
      return new int[0];
    }
    int[] result = new int[T.length];
    result[T.length - 1] = 0;
    for (int i = 0; i < T.length - 1; i++) {
      int j = i;
      while (j < T.length && T[j] <= T[i]) {
        j++;
      }
      result[i] = (j >= T.length) ? 0 : j - i;
    }
    return result;
  }
}
