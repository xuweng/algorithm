package com.jianzi.offer.suati;

/**
 * 官方：面试题16. 数值的整数次方
 */
public class g16 {
  /**
   * 作者：jyd
   * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow(double x, int n) {
    if (x == 0) return 0;
    long b = n;
    double res = 1.0;
    if (b < 0) {
      x = 1 / x;
      b = -b;
    }
    while (b > 0) {
      if ((b & 1) == 1) res *= x;
      x *= x;
      b >>= 1;
    }
    return res;
  }
}
