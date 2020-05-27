package com.leetcode.tag.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 */
public class CombinationSum3 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    backTrack(k, n, 1, 0, result, deque);

    return result;
  }

  /**
   * 参数太多.不要搞错参数
   *
   * @param K
   * @param n
   * @param count
   * @param sum
   * @param used
   * @param result
   * @param deque
   */
  public void backTrack(
          int K, int n, int begin, int sum, List<List<Integer>> result, Deque<Integer> deque) {
    if (sum > n) {
      return;
    }
    if (deque.size() == K) {
      if (sum == n) {
        result.add(new ArrayList<>(deque));
      }
      return;
    }
    for (int i = begin; i <= 9; i++) {
      if (i > n) {
        continue;
      }
      // 选择i
      deque.push(i);
      backTrack(K, n, i + 1, sum + i, result, deque);
      deque.pop();
    }
  }
}
