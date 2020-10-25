package com.leetcode.tag.contest.one;

/**
 * 5472. 重新排列字符串
 */
public class RestoreString {
  class Solution {
    public String restoreString(String s, int[] indices) {
      if (s == null || s.length() == 0) {
        return null;
      }
      char[] chars = new char[s.length()];
      for (int i = 0; i < indices.length; i++) {
        chars[indices[i]] = s.charAt(i);
      }

      return new String(chars);
    }
  }
}
