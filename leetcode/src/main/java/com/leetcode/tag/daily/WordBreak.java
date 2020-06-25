package com.leetcode.tag.daily;

import java.util.*;

/**
 * 先通过所有示例，再提交
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>139. 单词拆分
 */
public class WordBreak {
  Map<Character, List<String>> map;

  public boolean wordBreak(String s, List<String> wordDict) {
    if (wordDict == null || wordDict.isEmpty()) {
      return s.isEmpty();
    }
    map = new HashMap<>();
    for (String str : wordDict) {
      char key = str.charAt(0);
      List<String> list = map.getOrDefault(key, new ArrayList<>());
      list.add(str);
      map.put(key, list);
    }

    return backTrack(s);
  }

  public boolean backTrack(String s) {
    char key = s.charAt(0);
    if (!map.containsKey(key)) {
      return false;
    }
    List<String> list = map.get(key);

    // 候选集
    for (String str : list) {
      if (str.length() > s.length()) {
        continue;
      }
      String s1 = s.substring(0, str.length());
      if (!Objects.equals(s1, str)) {
        continue;
      }
      if (str.length() == s.length()) {
        return true;
      }
      if (backTrack(s.substring(str.length()))) {
        return true;
      }
    }
    return false;
  }
}
