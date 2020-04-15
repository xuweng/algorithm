package com.leetcode.tag.dp;

/**
 * 设计一个算法计算出最大利润
 *
 * <p>题目中只看到买入, 卖出, 冷冻期
 *
 * <p>难点:定义状态和确定子问题。状态定义为持股、不持股、冷冻期容易理解,不能定义为买入、卖出
 *
 * <p>* 309. 最佳买卖股票时机含冷冻期
 *
 * <p>dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益。
 *
 * <p>这里 j 取三个值：
 *
 * <p>0 表示不持股； 1 表示持股； 2 表示处在冷冻期。
 *
 * <p>作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class s309 {
  /**
   * 不持股可以由这两个状态转换而来：（1）昨天不持股，今天什么都不操作，仍然不持股。（2）昨天持股，今天卖了一股。
   *
   * <p>持股可以由这两个状态转换而来：（1）昨天持股，今天什么都不操作，仍然持股；（2）昨天处在冷冻期，今天买了一股；
   *
   * <p>处在冷冻期只可以由不持股转换而来，因为题目中说，刚刚把股票卖了，需要冷冻 1天。
   *
   * <p>作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * <p>复杂度分析：
   *
   * <p>时间复杂度：O(N)，这里 N 是股价数组的长度，只遍历了一次； 空间复杂度：O(N)。
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int len = prices.length;
    // 特判
    if (len < 2) {
      return 0;
    }

    int[][] dp = new int[len][3];

    // 初始化
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    dp[0][2] = 0;

    // 不持股。卖出+无操作;买入+卖出
    // 持股一定是买入。无操作+买入;买入+无操作
    // 冷冻期一定是昨天卖出
    for (int i = 1; i < len; i++) {
      // 第i天不持股
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      // 第i天持股;第i天买入?
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
      // 第i天冷冻期;昨天卖出
      dp[i][2] = dp[i - 1][0];
    }
    // 只取不持股
    return dp[len - 1][0];
  }

  /**
   * 思考状态压缩
   *
   * <p>由于当前天只参考了昨天的状态值，因此可以考虑使用滚动数组。
   *
   * <p>作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    int len = prices.length;
    // 特判
    if (len < 2) {
      return 0;
    }

    int[][] dp = new int[2][3];

    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    dp[0][2] = 0;

    for (int i = 1; i < len; i++) {
      dp[i & 1][0] = Math.max(dp[(i - 1) & 1][0], dp[(i - 1) & 1][1] + prices[i]);
      dp[i & 1][1] = Math.max(dp[(i - 1) & 1][1], dp[(i - 1) & 1][2] - prices[i]);
      dp[i & 1][2] = dp[(i - 1) & 1][0];
    }
    return Math.max(dp[(len - 1) & 1][0], dp[(len - 1) & 1][2]);
  }
}
