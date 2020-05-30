package com.leetcode.tag.backtracking;

import java.util.*;

/**
 * 90. 子集 II
 *
 * <p>说明：解集不能包含重复的子集。
 */
public class SubsetsWithDup {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Deque<Integer> deque = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    backTrack(nums, 0, deque, set, result);

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
   * @param set
   * @param result
   */
  public void backTrack(
          int[] nums, int begin, Deque<Integer> deque, Set<Integer> set, List<List<Integer>> result) {

    // 越界也要计算一个结果
    result.add(new ArrayList<>(deque));
    // 越界不用进入循环
    for (int i = begin; i < nums.length; i++) {
      if (set.contains(nums[begin])) {
        continue;
      }
      deque.push(nums[i]);
      backTrack(nums, i + 1, deque, set, result);
      // 以下部分都属于回溯
      deque.pop();

      set.add(nums[begin]);
    }
  }
}
