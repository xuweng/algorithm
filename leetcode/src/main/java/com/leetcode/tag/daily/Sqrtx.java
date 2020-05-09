package com.leetcode.tag.daily;

/**
 * 69. x 的平方根
 */
public class Sqrtx {
  public int mySqrt(int x) {
    return re(0, x, x);
  }

  /**
   * 因为leetcode的test case x=2147395599，
   *
   * <p>在算mid*mid的时候造成溢出，所以mid不能使用int型来接，要使用long型防止溢出
   *
   * <p>（Java中Integer型的范围：-2147483648 到2147483648）
   *
   * @param low
   * @param high
   * @param x
   * @return
   */
  public int re(int low, int high, int x) {
    if (x <= 1) {
      return x;
    }
    // 递归终止条件
    if (high - low <= 1) {
      return low;
    }
    // 在算mid*mid的时候造成溢出，所以mid不能使用int型来接，要使用long型防止溢出
    long middle = low + (high - low) / 2;
    long ping = middle * middle;
    if (ping == x) {
      return (int) middle;
    } else if (ping < x) {
      return re((int) middle, high, x);
    } else {
      return re(low, (int) middle, x);
    }
  }
}
