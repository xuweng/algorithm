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
    if (pattern == null || value == null) {
      return pattern == value;
    }
    if (pattern.isEmpty()) {
      return value.isEmpty();
    }
    if (value.isEmpty()) {
      return !pattern.contains("a") || !pattern.contains("b");
    }
    map = new HashMap<>();

    backTrack(pattern, value, 0);

    return result;
  }

  /**
   * 但需注意"a"和"b"不能同时表示相同的字符串
   *
   * @param pattern
   * @param value
   * @param patternIndex
   */
  private void backTrack(String pattern, String value, int patternIndex) {
    if (value.isEmpty()) {
      if (patternIndex == pattern.length()) {
        result = true;
      }

      return;
    }
    if (patternIndex == pattern.length()) {
      if (value.isEmpty()) {
        result = true;
      }

      return;
    }

    for (int i = 0; i < value.length(); i++) {
      String str = value.substring(0, i + 1);
      if (map.containsKey(pattern.charAt(patternIndex))) {
        if (!map.get(pattern.charAt(patternIndex)).equals(str)) {
          continue;
        }
      } else {
        if (map.containsValue(str)) {
          continue;
        }
      }

      map.putIfAbsent(pattern.charAt(patternIndex), str);
      backTrack(pattern, value.substring(i + 1), patternIndex + 1);
      map.remove(pattern.charAt(patternIndex));
    }
  }
}
