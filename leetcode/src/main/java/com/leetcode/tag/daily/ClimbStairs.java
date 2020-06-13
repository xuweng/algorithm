package com.leetcode.tag.daily;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
  int[] meno;

  public int climbStairs(int n) {
    meno = new int[n + 1];
    return re(n);
  }

  public int re(int n) {
    if (meno[n] != 0) {
      return meno[n];
    }
    // 终止条件
    if (n == 1 || n == 0) {
      return 1;
    }
    int result = re(n - 1) + re(n - 2);
    meno[n] = result;

    return result;
  }
}
