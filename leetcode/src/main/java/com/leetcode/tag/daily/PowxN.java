package com.leetcode.tag.daily;

/**
 * n很大，结果会溢出呀，为什么不处理溢出呢
 *
 * <p>实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class PowxN {
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
    // java中int类型的范围n∈[−2147483648,2147483647]，如果n=−2147483648，执行-n就会出现越界，所以转为long来操作就安全了。
    long N = n;
    return (n >= 0) ? re(x, N) : 1.0 / re(x, -N);
  }

  public double re(double x, long n) {
    // 递归终止条件
    // 两个参数,递归终止条件比较麻烦
    if (n == 0) {
      return 1.0;
    }
    double mid = re(x, n >> 1);
    return n % 2 == 0 ? mid * mid : mid * mid * x;
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

  /**
   * 直接从左到右进行推导看上去很困难，因为在每一步中，我们不知道在将上一次的结果平方之后，还需不需要额外乘 x。
   *
   * <p>但如果我们从右往左看，分治的思想就十分明显了：
   */
  class Solution1 {
    double quickMul(double x, long N) {
      double ans = 1.0;
      // 贡献的初始值为 x
      double xContribute = x;
      // 在对 N 进行二进制拆分的同时计算答案
      while (N > 0) {
        if (N % 2 == 1) {
          // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
          ans *= xContribute;
        }
        // 将贡献不断地平方
        xContribute *= xContribute;
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

  class Solution3 {
    public double myPow(double x, int n) {
      if (x == 1) {
        return 1;
      }
      if (x == -1) {
        return n % 2 == 0 ? 1 : -1;
      }

      if (n == 0) {
        return 1;
      }
      if (n == 1) {
        return x;
      }
      if (n == -1) {
        return 1 / x;
      }

      double prev = myPow(x, n / 2);
      return prev * prev * myPow(x, n % 2);
    }
  }
}
