package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class PowxN {
  Map<String, Double> map = new HashMap<>();

  /**
   * 没有重叠子问题
   *
   * <p>没有子问题依赖
   *
   * <p>加上缓存也没有用
   *
   * <p>Integer.MAX_VALUE + 1 = Integer.MIN_VALUE = -2147483648
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow(double x, int n) {
    return (n >= 0) ? re(x, n) : 1 / re(x, -n);
  }

  public double re(double x, int n) {
    if (map.containsKey(String.valueOf(n))) {
      return map.get(String.valueOf(n));
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
      map.put(String.valueOf(n), x);
      return map.get(String.valueOf(n));
    }
    double mid = re(x, n >> 1);
    double result = n % 2 == 0 ? mid * mid : mid * mid * x;
    map.put(String.valueOf(n), result);
    return map.get(String.valueOf(n));
  }
}
