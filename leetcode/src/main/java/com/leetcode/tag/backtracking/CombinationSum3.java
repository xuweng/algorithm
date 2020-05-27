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
   * @param begin  从第一个位置开始选择
   * @param sum
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
        break;
      }
      // 选择i
      deque.push(i);
      backTrack(K, n, i + 1, sum + i, result, deque);
      deque.pop();
    }
  }

  class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int k = 0, n = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
      if (k == 0 || n == 0) {
        ans.add(new ArrayList<>());
        return ans;
      }
      this.k = k;
      this.n = n;
      backtrace(new ArrayList<>(), 0, n, 1);
      return ans;
    }

    public void backtrace(List<Integer> list, int cnt, int target, int start) {
      if (cnt == k && target == 0) {
        ans.add(new ArrayList<>(list));
        return;
      }
      for (int i = start; i <= 9; i++) {
        if (i > target) {
          break;
        }
        list.add(i);
        backtrace(list, cnt + 1, target - i, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }
}
