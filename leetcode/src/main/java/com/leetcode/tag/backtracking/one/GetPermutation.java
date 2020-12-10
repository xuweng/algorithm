package com.leetcode.tag.backtracking.one;

import java.util.ArrayList;
import java.util.List;

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
    if (temp.length() >= n) {
      count++;
      if (count == k) {
        result = temp;
      }
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

  /**
   * 优秀代码
   *
   * <p>简洁代码
   *
   * <p>代码模板
   *
   * <p>代码模板
   *
   * <p>代码模板
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>代码模板
   *
   * <p>代码模板
   *
   * <p>代码模板
   */
  class Solution {
    public String getPermutation(int n, int k) {
      int[] factorials = new int[n];
      List<Integer> nums =
              new ArrayList() {
                {
                  add(1);
                }
              };

      factorials[0] = 1;
      for (int i = 1; i < n; ++i) {
        // generate factorial system bases 0!, 1!, ..., (n - 1)!
        factorials[i] = factorials[i - 1] * i;
        // generate nums 1, 2, ..., n
        nums.add(i + 1);
      }

      // fit k in the interval 0 ... (n! - 1)
      --k;

      // compute factorial representation of k
      StringBuilder sb = new StringBuilder();
      for (int i = n - 1; i > -1; --i) {
        int idx = k / factorials[i];
        k -= idx * factorials[i];

        sb.append(nums.get(idx));
        nums.remove(idx);
      }
      return sb.toString();
    }
  }
}
