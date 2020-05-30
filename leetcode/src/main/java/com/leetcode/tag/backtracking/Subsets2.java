package com.leetcode.tag.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets2 {
  public List<List<Integer>> subsets(int[] nums) {
    Deque<Integer> deque = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();

    backTrack(nums, 0, deque, result);

    return result;
  }

  /**
   * 越界时计算出一个结果
   *
   * @param nums
   * @param begin
   * @param deque
   * @param result
   */
  public void backTrack(int[] nums, int begin, Deque<Integer> deque, List<List<Integer>> result) {
    result.add(new ArrayList<>(deque));

    for (int i = begin; i < nums.length; i++) {
      deque.push(nums[i]);
      backTrack(nums, i + 1, deque, result);
      deque.pop();
    }
  }
}
