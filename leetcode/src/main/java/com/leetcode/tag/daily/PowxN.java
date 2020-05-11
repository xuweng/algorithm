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
    if (n == 0 || x == 1.0) {
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

  public double loop(double x, int n) {
    if (n == 0 || x == 1.0) {
      return 1.0;
    }
    if (x == -1) {
      return n % 2 == 0 ? 1 : -1;
    }
    if (n == 1) {
      return x;
    }

    double result = x;
    for (int i = 2; i <= n; i = 2 * i) {
      result = n % 2 == 0 ? result * result : result * result * x;
    }

    return result;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public double quickMul(double x, long N) {
      if (N == 0) {
        return 1.0;
      }
      double y = quickMul(x, N / 2);
      return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
      long N = n;
      return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
  }

  class Solution1 {
    double quickMul(double x, long N) {
      double ans = 1.0;
      // 贡献的初始值为 x
      double x_contribute = x;
      // 在对 N 进行二进制拆分的同时计算答案
      while (N > 0) {
        if (N % 2 == 1) {
          // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
          ans *= x_contribute;
        }
        // 将贡献不断地平方
        x_contribute *= x_contribute;
        // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
        N /= 2;
      }
      return ans;
    }

    public double myPow(double x, int n) {
      long N = n;
      return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
  }
}
