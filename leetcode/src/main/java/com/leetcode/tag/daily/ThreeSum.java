package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 三数之和
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    Set<Integer> maxSet = new HashSet<>();
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int third = -nums[i] - nums[j];
        int max = Math.max(third, Math.max(nums[i], nums[j]));
        if (maxSet.contains(max)) {
          continue;
        }
        if (set.contains(third)) {
          maxSet.add(max);
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(third);
          result.add(list);
          break;
        }
      }
    }

    return result;
  }
}
