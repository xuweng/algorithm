package com.leetcode.tag.daily;

/**
 * 983. 最低票价
 *
 * <p>看出用dp来做
 */
public class MinimumCostForTickets {
  /**
   * 状态方程错误
   *
   * <p>审题.审题.审题
   *
   * <p>数据范围.数据范围.数据范围.数据范围.数据范围
   *
   * <p>1 <= days.length <= 365
   *
   * <p>条件判断错误
   *
   * @param days
   * @param costs
   * @return
   */
  public int mincostTickets(int[] days, int[] costs) {
    int[] dpMin = new int[366];
    dpMin[1] = costs[0];
    for (int i = 1; i < days.length; i++) {
      if (days[i] >= 1 && days[i] <= 7) {
        dpMin[days[i]] = Math.min(dpMin[days[i - 1]] + costs[0], costs[1]);
      } else if (days[i] > 7) {
        int a = dpMin[days[i - 1]] + costs[0];
        // dpMin[days[i] - 7]已经计算?
        int b = Integer.MAX_VALUE;
        if (days[i] - 7 <= days[i - 1] && days[i] - 7 < days.length) {
          b = dpMin[days[days[i] - 7]] + costs[1];
        }
        int c = Integer.MAX_VALUE;
        if (days[i] >= 30 && days[i] - 30 <= days[i - 1] && days[i] - 30 < days.length) {
          c = dpMin[days[days[i] - 30]] + costs[2];
        }
        dpMin[days[i]] = Math.min(Math.min(a, b), c);
      }
    }

    return dpMin[days[days.length - 1]];
  }
}
