package com.leetcode.tag.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 89. 格雷编码
 */
public class GrayCode {
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    backTrack(n, "", result);

    return result;
  }

  /**
   * 没搞懂题目
   *
   * @param n
   * @param temp
   * @param result
   */
  public void backTrack(int n, String temp, List<Integer> result) {
    if (n == 0) {
      result.add(Integer.parseInt(temp, 2));
      return;
    }
    for (int i = 0; i <= 1; i++) {
      backTrack(n - 1, temp + i, result);
    }
  }
}
