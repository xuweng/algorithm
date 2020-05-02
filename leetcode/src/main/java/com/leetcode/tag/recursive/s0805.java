package com.leetcode.tag.recursive;

/**
 * 面试题 08.05. 递归乘法
 */
public class s0805 {
  public int multiply(int A, int B) {
    return (A > B) ? re(A, B) : re(B, A);
  }

  /**
   * b个a相加
   *
   * @param a
   * @param b
   * @return
   */
  public int re(int a, int b) {
    if (b <= 0) {
      return 0;
    }
    return a + re(a, b - 1);
  }
}
