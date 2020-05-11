package com.leetcode.tag.daily;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class PowxN {
  public double myPow(double x, int n) {
    // 递归终止条件
    // 两个参数,递归终止条件比较麻烦
    if (n == 0) {
      return 1.0;
    }
    if (x == 1) {
      return 1;
    }
    if (x == -1) {
      return n % 2 == 0 ? 1 : -1;
    }
    if (n == 1) {
      return x;
    }
    if (n < 0) {
      return 1 / myPow(x, -n);
    }
    double mid = myPow(x, n >> 1);
    if (n % 2 == 0) {
      return mid * mid;
    } else {
      return mid * mid * x;
    }
  }
}
