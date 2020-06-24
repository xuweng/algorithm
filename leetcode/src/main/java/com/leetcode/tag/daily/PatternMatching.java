package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 熟练回溯
 *
 * <p>回溯不够熟练
 *
 * <p>面试题 16.18. 模式匹配
 */
public class PatternMatching {
  private Map<Character, String> map;
  // 字母匹配成功次数
  private Map<Character, Integer> countMap;

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
    countMap = new HashMap<>();

    return backTrack(pattern, value, 0);
  }

  /**
   * 终于知道哪里错误了
   *
   * <p>但需注意"a"和"b"不能同时表示相同的字符串
   *
   * @param pattern
   * @param value
   * @param patternIndex
   */
  private boolean backTrack(String pattern, String value, int patternIndex) {
    if (patternIndex == pattern.length()) {
      return value.isEmpty();
    }
    if (value.isEmpty()) {
      return false;
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
      countMap.put(
              pattern.charAt(patternIndex), countMap.getOrDefault(pattern.charAt(patternIndex), 0) + 1);
      if (backTrack(pattern, value.substring(i + 1), patternIndex + 1)) {
        return true;
      }
      // 回溯会删掉以前的记录(不能删掉以前的记录)
      // 如果以前有记录就不能删除
      if (pre(pattern, patternIndex)) {
        map.remove(pattern.charAt(patternIndex));
      }
    }

    return false;
  }

  private boolean pre(String pattern, int patternIndex) {
    return IntStream.range(0, patternIndex)
            .noneMatch(i -> pattern.charAt(i) == pattern.charAt(patternIndex));
  }
}
