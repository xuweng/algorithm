package com.leetcode.tag.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.11. 跳水板
 */
public class s1611 {

  public int[] divingBoard(int shorter, int longer, int k) {
    if (k == 0) {
      return new int[0];
    }
    int[] arrays = toArray(re(shorter, longer, k));

    Arrays.sort(arrays);
    return arrays;
  }

  public List<Integer> re(int shorter, int longer, int k) {
    List<Integer> list = new ArrayList<>();

    if (k == 1) {
      // 取shorter
      if (!list.contains(shorter)) {
        list.add(shorter);
      }
      // 取longer
      if (!list.contains(longer)) {
        list.add(longer);
      }

      return list;
    }
    // 子问题
    List<Integer> l = re(shorter, longer, k - 1);
    for (int i : l) {
      if (!list.contains(i + shorter)) {
        list.add(i + shorter);
      }
      if (!list.contains(i + longer)) {
        list.add(i + longer);
      }
    }
    return list;
  }

  public int[] toArray(List<Integer> list) {
    int[] arrays = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      arrays[i] = list.get(i);
    }

    return arrays;
  }
}
