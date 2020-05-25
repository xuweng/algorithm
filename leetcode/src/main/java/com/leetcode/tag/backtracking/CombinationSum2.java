package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 40. 组合总和 II
 *
 * <p>看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>candidates 中的每个数字在每个组合中只能使用一次。
 */
public class CombinationSum2 {
  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> stack = new Stack<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);

    backTrack(candidates, 0, 0, target);

    return result;
  }

  public void backTrack(int[] candidates, int select, int sum, int target) {
    if (sum > target) {
      return;
    }
    if (sum == target) {
      result.add(new ArrayList<>(stack));
      return;
    }
    int i = select;
    while (i < candidates.length) {
      stack.push(candidates[i]);
      // 需要一些剪枝
      backTrack(candidates, i + 1, candidates[i] + sum, target);
      stack.pop();
      // 挑选下一个分支
      int j = i + 1;
      while (j < candidates.length && candidates[i] == candidates[j]) {
        j++;
      }
      if (j >= candidates.length) {
        return;
      }
      i = j;
    }
  }
}
