package com.leetcode.tag.daily;

/**
 * 面试题 16.18. 模式匹配
 */
public class PatternMatching {
  public boolean patternMatching(String pattern, String value) {
    return true;
  }

  private void backTrack(String pattern, String value, int index) {
    for (int i = 0; i < value.length(); i++) {
      String str = value.substring(0, i + 1);
      backTrack(pattern, value.substring(i + 1), i);
    }
  }
}
