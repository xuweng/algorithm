package com.leetcode.tag.daily;

/**
 * 718. 最长重复子数组
 *
 * <p>是否连续?
 *
 * <p>是否连续？
 *
 * <p>是否连续？
 *
 * <p>子数组一定连续。子串一定连续。
 */
public class MaximumLengthRepeatedSubarray {
  public int findLength(int[] A, int[] B) {
    // 排序不对。改变原来的顺序。不是子数组。
    //    Arrays.sort(A);
    //    Arrays.sort(B);

    return 0;
  }

  /**
   * 长度最长。最优解。容易想到dp。
   *
   * <p>计算顺序?
   *
   * <p>定义状态
   *
   * <p>状态转移方程?不能简单的递推。
   *
   * @param A
   * @param B
   * @return
   */
  public int dp(int[] A, int[] B) {
    int[][] dpMax = new int[A.length][B.length];
    return dpMax[A.length - 1][B.length - 1];
  }
}
