package com.leetcode.tag.daily;

/**
 * 983. 最低票价
 *
 * <p>看出用dp来做
 */
public class MinimumCostForTickets {
  public int mincostTickets(int[] days, int[] costs) {
    int[] dpMin = new int[32];
    dpMin[1] = costs[0];
    for (int i = 1; i < days.length; i++) {
      dpMin[days[i]] = Integer.MAX_VALUE;
      if (days[i] >= 1 && days[i] <= 7) {
        dpMin[days[i]] = Math.min(dpMin[days[i - 1]] + costs[0], costs[1]);
      } else if (days[i] > 7 && days[i] <= 30) {
        int a = dpMin[days[i - 1]] + costs[0];
        int b = dpMin[days[i] - 7] + costs[1];
        int c = costs[2];
        dpMin[days[i]] = Math.min(Math.min(a, b), c);
      } else {
        dpMin[days[i]] = Math.min(dpMin[days[i - 1]] + costs[0], dpMin[days[i] - 7] + costs[1]);
      }
    }

    return dpMin[days[days.length - 1]];
  }
}
