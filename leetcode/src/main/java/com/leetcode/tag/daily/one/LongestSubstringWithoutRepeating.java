package com.leetcode.tag.daily.one;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * <p>最简单的方法.思路正确.最简单的方法.思路正确.
 */
public class LongestSubstringWithoutRepeating {
  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    if (s.length() <= 1) {
      return s.length();
    }

    int max = Integer.MIN_VALUE;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length - 1; i++) {
      Set<Character> characterSet = new HashSet<>();
      characterSet.add(chars[i]);
      for (int j = i + 1; j < chars.length; j++) {
        if (!characterSet.contains(chars[j])) {
          characterSet.add(chars[j]);
          max = Math.max(max, characterSet.size());
        } else {
          max = Math.max(max, characterSet.size());
          break;
        }
      }
    }

    return max;
  }
}
