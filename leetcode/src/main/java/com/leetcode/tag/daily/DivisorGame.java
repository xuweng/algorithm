package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 1025. 除数博弈
 */
public class DivisorGame {
  /**
   * 1 <= N <= 1000
   */
  static class Solution {
    public boolean divisorGame(int N) {
      return backTrack(N, 0);
    }

    private boolean backTrack(int N, int count) {
      List<Integer> list = getCandidate(N);
      if (list.isEmpty()) {
        return count % 2 != 0;
      }

      for (int i : list) {
        if (backTrack(N - i, ++count)) {
          return true;
        }
      }

      return false;
    }

    /**
     * 选出任一 x，满足 0 < x < N 且 N % x == 0
     *
     * @param n
     * @return
     */
    private List<Integer> getCandidate(int n) {
      List<Integer> result = new ArrayList<>();

      for (int i = 1; i < n; i++) {
        if (n % i == 0) {
          result.add(i);
        }
      }

      return result;
    }
  }
}
