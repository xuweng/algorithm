package com.leetcode.tag.daily;

import java.util.Map;

/**
 * 面试题 16.18. 模式匹配
 */
public class PatternMatching {
  private Map<Character, String> map;

  public boolean patternMatching(String pattern, String value) {
    return true;
  }

  private void backTrack(String pattern, String value, int patternIndex, int valueIndex) {
    for (int i = 0; i < value.length(); i++) {
      String str = value.substring(0, i + 1);
      if (map.containsKey(pattern.charAt(patternIndex))
              && !map.get(pattern.charAt(patternIndex)).equals(str)) {
        continue;
      }

      map.putIfAbsent(pattern.charAt(patternIndex), str);
      backTrack(pattern, value.substring(i + 1), i, valueIndex);
    }
  }
}
