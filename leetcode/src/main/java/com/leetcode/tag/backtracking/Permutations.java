package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permutations {
  /**
   * 老办法
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> permute(int[] nums) {
    return re(nums, nums.length - 1);
  }

  public List<List<Integer>> re(int[] nums, int n) {
    if (n <= 0) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      list.add(nums[0]);
      result.add(list);

      return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> lists = re(nums, n - 1);
    if (lists == null) {
      return result;
    }

    for (List<Integer> list : lists) {
      List<Integer> list2 = new ArrayList<>();
      list2.add(nums[n]);
      list2.addAll(list);
      result.add(list2);
      for (int i = 0; i < list.size(); i++) {
        List<Integer> list1 = new ArrayList<>(list.subList(0, i + 1));
        list1.add(nums[n]);
        if (i != lists.size() - 1) {
          list1.addAll(list.subList(i + 1, list.size()));
        }

        result.add(list1);
      }
    }

    return result;
  }
}
