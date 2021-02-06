package com.leetcode.tag.dp.one.one;

/**
 * 279. 完全平方数
 *
 * <p>假设最少是k,最后一个数值为ak
 *
 * <p>前面是k-1,值为n-ak
 *
 * <p>方程:f(n)=min( f(n-ak)+1 );思考ak?枚举ak
 *
 * <p>初始化;边界条件;计算顺序
 */
public class s279 {
  /**
   * 最后一步
   *
   * <p>写出状态转移方程
   *
   * @param n
   * @return
   */
  public int numSquares(int n) {
    int[] minDp = new int[n + 1];
    minDp[0] = 0;
    minDp[1] = 1;
    for (int i = 2; i <= n; i++) {
      // 初始化最大值
      minDp[i] = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        minDp[i] = Math.min(minDp[i], minDp[i - j * j] + 1);
      }
    }

    return minDp[n];
  }
}
