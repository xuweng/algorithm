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

    List<String> result = new ArrayList<>();

    backTrack(s, 0, "", result);

    return result.toArray(new String[0]);
  }

  private void backTrack(String s, int start, String temp, List<String> result) {
    if (temp.length() == s.length()) {
      result.add(temp);
      return;
    }
    for (int i = start; i < s.length(); i++) {
      if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
        continue;
      }
      backTrack(s, i + 1, temp + s.charAt(i), result);
    }
  }
}
