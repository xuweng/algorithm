package com.leetcode.tag.contest.one;

import java.util.Arrays;

/**
 * 竞赛
 */
public class Contest {
  public int minTime(int[] time, int m) {
    if (time == null || time.length == 0 || time.length <= m) {
      return 0;
    }

    Arrays.sort(time);

    int result = 0;
    for (int i = time.length - 1; i >= 0; i--) {
      int s = (m > 0) ? 0 : time[i];
      result += s;
      m--;
    }

    return result;
  }
}
