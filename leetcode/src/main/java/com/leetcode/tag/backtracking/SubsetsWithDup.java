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
    Deque<Integer> deque2 = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();

    backTrack(nums, 0, deque, deque2, result);

    return result;
  }

  /**
   * 每条路径可以有重复
   *
   * <p>分支不能有重复
   *
   * @param nums
   * @param begin
   * @param deque
   * @param result
   */
  public void backTrack(
          int[] nums,
          int begin,
          Deque<Integer> deque,
          Deque<Integer> deque2,
          List<List<Integer>> result) {

    // 越界也要计算一个结果
    result.add(new ArrayList<>(deque));
    // 越界不用进入循环
    for (int i = begin; i < nums.length; i++) {
      if (deque2.contains(nums[begin])) {
        continue;
      }
      deque.push(nums[i]);
      deque2.push(nums[i]);
      backTrack(nums, i + 1, deque, deque2, result);
      // 以下部分都属于回溯
      deque.pop();
      if (deque2.size() != 1) {
        deque2.pop();
      }
    }
  }
}
