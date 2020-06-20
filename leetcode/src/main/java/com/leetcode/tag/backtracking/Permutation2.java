package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归深度
 *
 * <p>重复计算
 *
 * <p>剑指 Offer 38. 字符串的排列
 */
public class Permutation2 {
  public String[] permutation(String s) {

    boolean[] used = new boolean[s.length()];
    List<String> result = new ArrayList<>();

    backTrack(s, used, "", result);

    return result.toArray(new String[0]);
  }

  private void backTrack(String s, boolean[] used, String temp, List<String> result) {
    if (temp.length() == s.length()) {
      result.add(temp);
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      backTrack(s, used, temp + s.charAt(i), result);
      used[i] = false;
    }
  }
}
