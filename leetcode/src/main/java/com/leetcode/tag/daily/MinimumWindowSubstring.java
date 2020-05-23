package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
public class MinimumWindowSubstring {
  Map<Character, Integer> tMap;

  public String minWindow(String s, String t) {
    initTMap(t);
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
    Map<Character, Integer> sMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      if (sMap.getOrDefault(t.charAt(i), -1) < tMap.get(t.charAt(i))) {
        return false;
      }
    }

    return true;
  }

  public Map<Character, Integer> initTMap(String t) {
    tMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    return tMap;
  }
}
