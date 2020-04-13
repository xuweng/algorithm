package com.jianzi.offer.suati;

/**
 * 面试题16. 数值的整数次方
 */
public class s16 {
  /**
   * 递归导致大数溢出
   *
   * <p>执行出错信息： Line 18: java.lang.StackOverflowError
   *
   * <p>最后执行的输入： 2.00000 -2147483648
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow(double x, int n) {
    int myN = n;
    if (n < 0) {
      myN = -n;
    }

    double result = recursive(x, myN);
    return (n < 0) ? (1.0 / result) : result;
  }

  /**
   * -100.0 < x < 100.0
   *
   * <p>n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
   *
   * <p>复杂度分析：
   *
   * <p>时间复杂度 O(log​n) ： 二分的时间复杂度为对数级别。
   *
   * <p>空间复杂度 O(1) ： resres, bb 等变量占用常数大小额外空间。
   *
   * <p>作者：jyd
   * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param x
   * @param n
   * @return
   */
  public double recursive(double x, int n) {
    if (x == 0 || x == 1) return x;
    if (n == 0) return 1;
    if (n == 1) return x;

    // 位运算
    double result = recursive(x, n >> 1);
    result *= result;
    if ((n & 1) == 1) {
      // n为基数
      result *= x;
    }
    return result;
  }
}
