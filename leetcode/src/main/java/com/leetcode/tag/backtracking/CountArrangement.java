package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 526. 优美的排列
 */
public class CountArrangement {
  public int countArrangement(int N) {
    boolean[] used = new boolean[N + 1];
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();

    backTrack(N, 1, used, result, stack);

    return result.size();
  }

  private void backTrack(
          int N, int start, boolean[] used, List<List<Integer>> result, Deque<Integer> stack) {
    if (start > N) {
      result.add(new ArrayList<>(stack));
      return;
    }
    for (int i = 1; i <= N; i++) {
      if (used[i]) {
        continue;
      }
      if (i % start == 0 || start % i == 0) {
        used[i] = true;
        stack.push(i);
        backTrack(N, start + 1, used, result, stack);
        used[i] = false;
        stack.pop();
      }
    }
  }
}
