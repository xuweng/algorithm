package com.leetcode.tag.daily;

import java.util.*;

/**
 * 搞懂题目
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
  public boolean wordBreak(String s, List<String> wordDict) {
    if (wordDict == null || wordDict.isEmpty()) {
      return s.isEmpty();
    }

    Map<Character, List<String>> map = new HashMap<>();

    for (String str : wordDict) {
      char key = s.charAt(0);
      List<String> list = map.getOrDefault(key, new ArrayList<>());
      list.add(str);
      map.put(key, list);
    }

    int i = 0;
    while (i < s.length()) {
      char key = s.charAt(i);
      if (!map.containsKey(key)) {
        return false;
      }
      List<String> list = map.get(key);
      int length = -1;
      for (String str : list) {
        String s1 = s.substring(i, str.length());
        if (Objects.equals(s1, str)) {
          length = str.length();
          break;
        }
      }
      if (length == -1) {
        return false;
      }
      i = length;
    }
    return true;
  }
}
