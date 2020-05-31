package com.leetcode.tag.backtracking;

import java.util.*;

/**
 * 47. 全排列 II
 */
public class PermuteUnique {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    Arrays.sort(nums);

    backTrack(nums, 0, nums.length, deque, result);

    return result;
  }

  public void backTrack(
          int[] nums, int count, int n, Deque<Integer> deque, List<List<Integer>> result) {
    if (count >= n) {
      result.add(new ArrayList<>(deque));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i >= 1 && nums[i] == nums[i - 1]) {
        continue;
      }
      deque.push(nums[i]);
      backTrack(delete(nums, i), count + 1, n, deque, result);
      deque.pop();
    }
  }

  public int[] delete(int[] nums, int index) {
    int[] result = new int[nums.length - 1];
    if (nums.length == 1) {
      return result;
    }
    if (index == nums.length - 1) {
      System.arraycopy(nums, 0, result, 0, nums.length - 1);
      return result;
    }
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i == index) {
        continue;
      }
      result[j++] = nums[i];
    }
    return result;
  }
}
