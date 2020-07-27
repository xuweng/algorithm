package com.leetcode.tag.daily;

import java.util.Arrays;
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

  class Solution1 {
    public boolean isSubsequence(String s, String t) {
      if (t == null || t.length() == 0) {
        return s == null || s.length() == 0;
      }
      char[] schars = s.toCharArray();
      char[] tchars = t.toCharArray();

      Arrays.sort(schars);
      Arrays.sort(tchars);

      int length = Math.min(s.length(), t.length());
      for (int i = 0; i < length; i++) {
        if (schars[i] != tchars[i]) {
          return false;
        }
      }
      return true;
    }
  }

  class Solution2 {
    public boolean isSubsequence(String s, String t) {
      if (t == null || t.length() == 0) {
        return s == null || s.length() == 0;
      }
      int index = 0;
      for (int i = 0; i < s.length(); i++) {
        if (index >= t.length()) {
          return false;
        }
        boolean flag = true;
        for (int j = index; j < t.length(); j++) {
          if (s.charAt(i) == t.charAt(j)) {
            index = j + 1;
            flag = false;
            break;
          }
        }
        if (flag) {
          return false;
        }
      }

      return true;
    }
  }

  /**
   * 方法一：双指针
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution4 {
    public boolean isSubsequence(String s, String t) {
      int n = s.length(), m = t.length();
      int i = 0, j = 0;
      while (i < n && j < m) {
        if (s.charAt(i) == t.charAt(j)) {
          i++;
        }
        j++;
      }
      return i == n;
    }
  }
}
