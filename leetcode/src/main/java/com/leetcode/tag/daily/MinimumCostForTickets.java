package com.leetcode.tag.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * 983. 最低票价
 *
 * <p>看出用dp来做
 */
public class MinimumCostForTickets {
  /**
   * 状态方程错误
   *
   * <p>代码简洁
   *
   * <p>子问题错误.后面推导都错
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
    dpMin[days[0]] = Math.min(Math.min(costs[0], costs[1]), costs[2]);
    for (int i = 1; i < days.length; i++) {
      int a = dpMin[days[i - 1]] + costs[0];
      // dpMin[days[i] - 7]已经计算?
      int xia = xia(days, i, days[i] - 7);
      int b = xia == 0 ? costs[1] : xia == -1 ? Integer.MAX_VALUE : dpMin[days[xia]] + costs[1];

      int xia1 = xia(days, i, days[i] - 30);
      int c =
              (xia1 == 0) ? costs[2] : (xia1 == -1) ? Integer.MAX_VALUE : dpMin[days[xia1]] + costs[2];
      dpMin[days[i]] = Math.min(Math.min(a, b), c);
    }

    return dpMin[days[days.length - 1]];
  }

  /**
   * days 按顺序严格递增
   *
   * @param days
   * @param value
   * @return
   */
  public int xia(int[] days, int index, int value) {
    if (value <= 0) {
      return 0;
    }
    if (value > days[index - 1]) {
      return -1;
    }
    int i = index;
    while (i >= 0 && value < days[i]) {
      i--;
    }
    return i + 1;
  }

  class Solution {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
      this.costs = costs;
      memo = new Integer[366];
      dayset = new HashSet();
      for (int d : days) {
        dayset.add(d);
      }
      return dp(1);
    }

    /**
     * 早知道看答案.浪费时间
     *
     * <p>动态规划不是很明显
     *
     * <p>动态规划计算顺序
     *
     * <p>计算顺序
     *
     * <p>计算顺序
     *
     * <p>方法一：记忆化搜索（日期变量型） 思路和算法
     *
     * <p>我们用 dp(i) 来表示从第 i 天开始到一年的结束，我们需要花的钱。考虑到一张通行证可以让我们在「接下来」的若干天进行旅行，
     *
     * <p>所以我们「从后往前」倒着进行动态规划。
     *
     * <p>作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/zui-di-piao-jie-by-leetcode-solution/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param i
     * @return
     */
    public int dp(int i) {
      if (i > 365) {
        return 0;
      }
      if (memo[i] != null) {
        return memo[i];
      }
      if (dayset.contains(i)) {
        memo[i] =
                Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
      } else {
        memo[i] = dp(i + 1);
      }
      return memo[i];
    }
  }
}
