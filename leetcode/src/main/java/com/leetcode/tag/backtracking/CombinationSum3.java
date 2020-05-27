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
    boolean[] used = new boolean[10];
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<Integer>();

    backTrack(k, n, 0, 0, used, result, deque);

    return result;
  }

  public void backTrack(
          int K,
          int n,
          int count,
          int sum,
          boolean[] used,
          List<List<Integer>> result,
          Deque<Integer> deque) {
    if (sum > n) {
      return;
    }
    if (count == K) {
      if (sum == n) {
        result.add(new ArrayList<>(deque));
      }
      return;
    }
    for (int i = 1; i <= 9; i++) {
      if (used[i] || i > sum) {
        continue;
      }
      deque.push(i);
      used[i] = true;
      backTrack(K, n, count + 1, sum + i, used, result, deque);
      used[i] = false;
      deque.pop();
    }
  }
}
