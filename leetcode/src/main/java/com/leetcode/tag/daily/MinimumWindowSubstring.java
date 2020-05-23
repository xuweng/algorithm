package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
public class MinimumWindowSubstring {
  Map<Character, Integer> tMap;

  public String minWindow(String s, String t) {
    initTMap(t);
    int min = Integer.MAX_VALUE;
    int low = -1, high = -1;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + t.length() - 1; j < s.length(); j++) {
        if (contain(s.substring(i, j + 1), t)) {
          int length = j - i + 1;
          if (length < min) {
            min = length;
            low = i;
            high = j;
          }
        }
      }
    }

    return (low == -1) ? "" : s.substring(low, high + 1);
  }

  public boolean contain(String s, String t) {
    Map<Character, Integer> sMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      if (sMap.getOrDefault(t.charAt(i), -1) < tMap.get(t.charAt(i))) {
        return false;
      }
    }

    return true;
  }

  public Map<Character, Integer> initTMap(String t) {
    tMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    return tMap;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    /**
     * 滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
      int tLen = t.length();
      for (int i = 0; i < tLen; i++) {
        char c = t.charAt(i);
        ori.put(c, ori.getOrDefault(c, 0) + 1);
      }
      // 左边界:l
      // 右边界:r
      // 滑动窗口:l-----r
      int l = 0, r = -1;
      int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
      int sLen = s.length();
      while (r < sLen) {
        ++r;
        if (r < sLen && ori.containsKey(s.charAt(r))) {
          cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
        }
        while (check() && l <= r) {
          if (r - l + 1 < len) {
            len = r - l + 1;
            ansL = l;
            ansR = l + len;
          }
          if (ori.containsKey(s.charAt(l))) {
            cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
          }
          ++l;
        }
      }
      return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
      for (Map.Entry<Character, Integer> characterIntegerEntry : ori.entrySet()) {
        Character key = characterIntegerEntry.getKey();
        Integer val = characterIntegerEntry.getValue();
        if (cnt.getOrDefault(key, 0) < val) {
          return false;
        }
      }
      return true;
    }
  }
}
