package com.leetcode.tag.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 90. 子集 II
 *
 * <p>说明：解集不能包含重复的子集。
 */
public class SubsetsWithDup {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Deque<Integer> deque = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> levels = new ArrayList<>();

    backTrack(nums, 0, 0, deque, levels, result);

    return result;
  }

  /**
   * 每条路径可以有重复
   *
   * <p>分支不能有重复。每层不能有重复。
   *
   * <p>不是每层不能有重复。是每个结点的分支不能有重复。
   *
   * @param nums
   * @param begin
   * @param deque
   * @param result
   */
  public void backTrack(
          int[] nums,
          int count,
          int begin,
          Deque<Integer> deque,
          List<List<Integer>> levels,
          List<List<Integer>> result) {

    if (count == levels.size()) {
      levels.add(new ArrayList<>());
    }

    // 越界也要计算一个结果
    result.add(new ArrayList<>(deque));
    // 越界不用进入循环
    for (int i = begin; i < nums.length; i++) {
      // 如何剪枝?如何剪枝?如何剪枝?如何剪枝?
      if (count != 0 && levels.get(count).contains(nums[i])) {
        continue;
      }
      deque.push(nums[i]);
      levels.get(count).add(nums[i]);
      backTrack(nums, count + 1, i + 1, deque, levels, result);
      // 以下部分都属于回溯
      deque.pop();
    }
  }
}
