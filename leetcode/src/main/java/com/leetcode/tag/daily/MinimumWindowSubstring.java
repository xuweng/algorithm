package com.leetcode.tag.daily;

/**
 * 76. 最小覆盖子串
 */
public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    int min = Integer.MAX_VALUE;
    int low = -1, high = -1;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + t.length() - 1; j < s.length(); j++) {
        if (contain(s.substring(i, j + 1), t)) {
          int length = j - i + 1;
          if (length < min) {
            min = length;
            low = i;
            high = j;
          }
        }
      }
    }

    return (low == -1) ? "" : s.substring(low, high + 1);
  }

  public boolean contain(String s, String t) {
    if (s.length() < t.length()) {
      return false;
    }
    for (int i = 0; i < t.length(); i++) {
      if (!s.contains(String.valueOf(t.charAt(i)))) {
        return false;
      }
    }

    return true;
  }
}
