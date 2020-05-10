package com.leetcode.tag.divide;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素
 */
public class FindMajorityElement {
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
    return -1;
  }
}
