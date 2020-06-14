package com.leetcode.tag.backtracking;

/**
 * 抄代码
 *
 * <p>代码模板
 *
 * <p>优秀代码
 *
 * <p>搞懂全部示例
 *
 * <p>60. 第k个排列
 */
public class GetPermutation {
  private int count;
  private String result;

  public String getPermutation(int n, int k) {
    boolean[] used = new boolean[n + 1];
    backTrack(n, k, used, "");
    return result;
  }

  public void backTrack(int n, int k, boolean[] used, String temp) {
    if (count == k) {
      result = temp;
      return;
    }

    if (temp.length() >= n) {
      count++;
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      backTrack(n, k, used, temp + i);
      used[i] = false;
    }
  }
}
