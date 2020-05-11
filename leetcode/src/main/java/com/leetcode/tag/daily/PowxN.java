package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class PowxN {
  double[] me;

  /**
   * Integer.MAX_VALUE + 1 = Integer.MIN_VALUE = -2147483648
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow(double x, int n) {
    me = new double[Math.abs(n) + 1];
    Arrays.fill(me, Double.MIN_VALUE);

    return (n >= 0) ? re(x, n) : 1 / re(x, -n);
  }

  public double re(double x, int n) {
    if (me[n] != Double.MIN_VALUE) {
      return me[n];
    }
    // 递归终止条件
    // 两个参数,递归终止条件比较麻烦
    if (n == 0.0 || x == 1.0) {
      return 1.0;
    }
    if (x == -1) {
      return n % 2 == 0 ? 1 : -1;
    }
    if (n == 1) {
      me[n] = x;
      return me[n];
    }
    double mid = re(x, n >> 1);
    me[n] = n % 2 == 0 ? mid * mid : mid * mid * x;
    return me[n];
  }
}
