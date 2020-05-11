package com.leetcode.tag.divide;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 */
public class CountSmallerNumbers {
  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length - 1; i++) {
      int count = 0;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          count++;
        }
      }
      list.add(count);
    }
    list.add(0);
    return list;
  }
}
