package com.leetcode.tag.daily;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 */
public class FindTheLongestSubstring {
  public int findTheLongestSubstring(String s) {
    char[] yuan = {'a', 'e', 'i', 'o', 'u'};
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        Map<Character, Integer> map = count(s, i, j);
        if (valide(yuan, map)) {
          count = Math.max(count, j - i + 1);
        }
      }
    }

    return count;
  }

  public boolean valide(char[] yuan, Map<Character, Integer> map) {
    for (char c : yuan) {
      int count = map.getOrDefault(c, 0);
      if (count % 2 != 0) {
        return false;
      }
    }
    return true;
  }

  public Map<Character, Integer> count(String s, int low, int high) {
    Map<Character, Integer> map = new TreeMap<>();
    IntStream.rangeClosed(low, high)
            .forEach(i -> map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1));
    return map;
  }
}
