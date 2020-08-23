package com.leetcode.tag.daily.one;

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

  class Solution {
    /**
     * 袖珍计算器算法
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
      if (x == 0) {
        return 0;
      }
      int ans = (int) Math.exp(0.5 * Math.log(x));
      return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
  }

  /** 二分查找 */
  class Solution2 {
    public int mySqrt(int x) {
      int l = 0, r = x, ans = -1;
      while (l <= r) {
        int mid = l + (r - l) / 2;
        if ((long) mid * mid <= x) {
          ans = mid;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      return ans;
    }
  }

  class Solution3 {
    /**
     * 方法三：牛顿迭代
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
      if (x == 0) {
        return 0;
      }

      double C = x, x0 = x;
      while (true) {
        double xi = 0.5 * (x0 + C / x0);
        if (Math.abs(x0 - xi) < 1e-7) {
          break;
        }
        x0 = xi;
      }
      return (int) x0;
    }
  }
}
