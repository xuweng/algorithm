package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 39. 组合总和
 */
public class CombinationSum {
  Stack<Integer> stack = new Stack<>();
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    backTrack(candidates, 0, 0, target);

    return result;
  }

  public void backTrack(int[] candidates, int select, int sum, int target) {
    if (sum > target) {
      return;
    }
    if (sum == target) {
      //      result.add(stack);
      // 一定要新建一个.stack是全局变量
      result.add(new ArrayList<>(stack));
      return;
    }
    for (int i = select; i < candidates.length; i++) {
      stack.push(candidates[i]);
      backTrack(candidates, i, candidates[i] + sum, target);
      stack.pop();
    }
  }
}
