package com.leetcode.tag.daily;

/**
 * 69. x 的平方根
 */
public class Sqrtx {
  public int mySqrt(int x) {
    return re(0, x);
  }

  public int re(int start, int x) {
    if (x <= 1) {
      return x;
    }
    // 递归终止条件
    if (x - start <= 1) {
      return start;
    }
    int middle = start + (x - start) / 2;
    int ping = middle * middle;
    if (ping == x) {
      return middle;
    } else if (ping < x) {
      return re(middle, x);
    } else {
      return re(start, middle);
    }
  }
}
