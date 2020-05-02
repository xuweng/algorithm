package com.leetcode.tag.recursive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

  public Set<Integer> re(int shorter, int longer, int k) {
    Set<Integer> set = new HashSet<>();

    if (k == 1) {
      // 取shorter
      set.add(shorter);
      // 取longer
      set.add(longer);
      return set;
    }
    // 子问题
    Set<Integer> s = re(shorter, longer, k - 1);
    for (int i : s) {
      set.add(i + shorter);
      set.add(i + longer);
    }
    return set;
  }

  public int[] toArray(Set<Integer> set) {
    int[] arrays = new int[set.size()];
    Integer[] s = set.toArray(new Integer[0]);
    for (int i = 0; i < s.length; i++) {
      arrays[i] = s[i];
    }

    return arrays;
  }
}
