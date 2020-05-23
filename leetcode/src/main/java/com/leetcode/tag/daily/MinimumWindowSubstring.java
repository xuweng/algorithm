package com.leetcode.tag.daily;

/**
 * 76. 最小覆盖子串
 */
public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    int min = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
      }
    }

    return null;
  }

  public boolean contain(String s, int i, String t, int j) {
    // s到尽头
    if (i >= s.length()) {
      return j >= t.length();
    }
    // t到尽头
    if (j >= t.length()) {
      return true;
    }

    return s.charAt(i) == t.charAt(j) ? contain(s, i + 1, t, j + 1) : contain(s, i + 1, t, j);
  }
}
