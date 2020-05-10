package com.leetcode.tag.divide;

import java.util.HashMap;
import java.util.Map;

/**
 * 932. 漂亮数组
 *
 * <p>想不出就看答案
 */
public class BeautifulArray {
  /**
   * 递推方程?怎么递推? n-1推出n?
   *
   * <p>-1还是两两划分?
   *
   * <p>新题型?新题型?新题型
   *
   * <p>例子:n=4--------->n=5?
   *
   * @param N
   * @return
   */
  public int[] beautifulArray(int N) {
    return null;
  }

  /**
   * 这题技巧性强，不容易想到
   *
   * <p>分治算法，如何划分出子问题是个能力啊
   */
  class Solution {
    Map<Integer, int[]> memo;

    public int[] beautifulArray(int N) {
      memo = new HashMap();
      return f(N);
    }

    public int[] f(int N) {
      if (memo.containsKey(N)) {
        return memo.get(N);
      }

      int[] ans = new int[N];
      if (N == 1) {
        ans[0] = 1;
      } else {
        int t = 0;
        for (int x : f((N + 1) / 2)) // odds
        {
          ans[t++] = 2 * x - 1;
        }
        for (int x : f(N / 2)) // evens
        {
          ans[t++] = 2 * x;
        }
      }
      memo.put(N, ans);
      return ans;
    }
  }
}
