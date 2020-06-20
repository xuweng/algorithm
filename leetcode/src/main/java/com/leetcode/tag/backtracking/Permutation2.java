package com.leetcode.tag.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 递归深度
 *
 * <p>重复计算
 *
 * <p>重复字符
 *
 * <p>剑指 Offer 38. 字符串的排列
 */
public class Permutation2 {
  public String[] permutation(String s) {

    boolean[] used = new boolean[s.length()];
    Set<String> result = new HashSet<>();

    backTrack(s, used, "", result);

    return result.toArray(new String[0]);
  }

  private void backTrack(String s, boolean[] used, String temp, Set<String> result) {
    if (temp.length() == s.length()) {
      result.add(temp);
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      // 过滤已经使用过和相邻重复字符
      if (used[i] || (temp.isEmpty() && i > 0 && s.charAt(i - 1) == s.charAt(i))) {
        continue;
      }
      used[i] = true;
      backTrack(s, used, temp + s.charAt(i), result);
      used[i] = false;
    }
  }
}
