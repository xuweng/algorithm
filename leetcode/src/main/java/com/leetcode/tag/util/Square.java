package com.leetcode.tag.util;

public class Square {
  /**
   * 数学技巧：所有的完全平方数都可以被表示成奇数和1+3+5+7+9 ...。
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare(int num) {
    int i = 1;
    while (num > 0) {
      num -= i;
      i += 2;
    }
    return num == 0;
  }

  /**
   * 是否是完全平方数
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare2(int num) {
    if (num == 0) {
      return true;
    }
    int left = 1, right = mySqrt(Integer.MAX_VALUE);
    while (right >= left) {
      int mid = left + (right - left) / 2;
      if (mid * mid == num) {
        return true;
      } else if (mid * mid > num) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }

  private static int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    long left = 1;
    long right = Integer.MAX_VALUE;
    while (true) {
      // 大数越界
      long mid = left + (right - left) / 2;
      if (mid > x / mid) {
        right = mid - 1;
      } else {
        if (mid + 1 > x / (mid + 1)) {
          return (int) mid;
        }
        left = mid + 1;
      }
    }
  }
}
