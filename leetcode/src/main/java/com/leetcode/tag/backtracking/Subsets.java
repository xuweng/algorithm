package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 */
public class Subsets {
  /**
   * 老方法
   *
   * <p>思路正确
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = re(nums, nums.length - 1);
    result.add(new ArrayList<>());

    return result;
  }

  public List<List<Integer>> re(int[] nums, int n) {
    List<List<Integer>> result = new ArrayList<>();
    if (n <= 0) {
      List<Integer> list = new ArrayList<>();
      list.add(nums[n]);
      result.add(list);
      return result;
    }

    List<List<Integer>> lists = re(nums, n - 1);
    if (lists == null) {
      return result;
    }
    List<Integer> list1 = new ArrayList<>();
    list1.add(nums[n]);
    result.add(list1);
    for (List<Integer> list : lists) {
      result.add(list);
      List<Integer> list2 = new ArrayList<>(list);
      list2.add(nums[n]);
      result.add(list2);
    }

    return result;
  }
}
