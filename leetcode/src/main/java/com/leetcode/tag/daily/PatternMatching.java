package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.18. 模式匹配
 */
public class PatternMatching {
  private Map<Character, String> map;
  private boolean result;

  public boolean patternMatching(String pattern, String value) {
    if (pattern == null) {
      return value == null;
    }
    if (pattern.isEmpty()) {
      return value.isEmpty();
    }

    map = new HashMap<>();

    backTrack(pattern, value, 0);

    return result;
  }

  private void backTrack(String pattern, String value, int patternIndex) {
    if (patternIndex == pattern.length()) {
      result = true;

      return;
    }

    for (int i = 0; i < value.length(); i++) {
      String str = value.substring(0, i + 1);
      if (map.containsKey(pattern.charAt(patternIndex))
              && !map.get(pattern.charAt(patternIndex)).equals(str)) {
        continue;
      }

      map.putIfAbsent(pattern.charAt(patternIndex), str);
      backTrack(pattern, value.substring(i + 1), patternIndex + 1);
      map.remove(pattern.charAt(patternIndex));
    }
  }
}
