package com.leetcode.tag.divide;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 */
public class MajorityElement {
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      } else {
        map.put(i, 1);
      }
      if (map.get(i) > nums.length / 2) {
        return i;
      }
    }
    return 0;
  }

  /**
   * 次数和具体数字
   *
   * @param nums
   * @param low
   * @param high
   * @return
   */
  public int divide(int[] nums, int low, int high) {
    int mid = low + (high - low) / 2;
    int n = high - low + 1;

    return 0;
  }
}
