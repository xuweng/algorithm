package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 392. 判断子序列
 */
public class IsSubsequence {
  class Solution {
    public boolean isSubsequence(String s, String t) {
      if (t == null || t.length() == 0) {
        return s == null || s.length() == 0;
      }
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      Map<Character, Integer> map1 = new HashMap<>();
      for (char c : t.toCharArray()) {
        map1.put(c, map1.getOrDefault(c, 0) + 1);
      }
      for (char c : s.toCharArray()) {
        if (!map1.containsKey(c)) {
          return false;
        }
        if (!Objects.equals(map1.get(c), map.get(c))) {
          return false;
        }
      }

      return true;
    }
  }
}
