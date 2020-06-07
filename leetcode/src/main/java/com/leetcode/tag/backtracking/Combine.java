package com.leetcode.tag.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>一定要看优秀代码
 *
 * <p>一定要看优秀代码
 *
 * <p>一定要看优秀代码
 *
 * <p>一定要看优秀代码
 *
 * <p>不要自恋
 *
 * <p>不要自恋
 *
 * <p>不要自恋
 *
 * <p>不要自恋
 *
 * <p>不要自恋
 *
 * <p>一定要看优秀代码
 *
 * <p>一定要看优秀代码
 */
public class Combine {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    backTrack(n, 0, k, 1, deque, result);
    return result;
  }

  /**
   * 算法模板
   *
   * <p>递归参数统计
   *
   * <p>一条路径不能有重复
   *
   * @param n
   * @param k
   * @param start
   */
  public void backTrack(
          int n, int count, int k, int start, Deque<Integer> deque, List<List<Integer>> result) {
    if (count == k) {
      result.add(new ArrayList<>(deque));
      return;
    }

    // 候选集
    for (int i = start; i <= n; i++) {
      // 当前选择i
      deque.push(i);
      // 回溯。从i+1开始选择。
      backTrack(n, count + 1, k, i + 1, deque, result);
      deque.pop();
    }
  }
}
