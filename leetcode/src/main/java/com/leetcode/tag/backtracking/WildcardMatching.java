package com.leetcode.tag.backtracking;

/**
 * 44. 通配符匹配
 */
public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    if (p == null) {
      return s == null;
    }
    if (p.isEmpty()) {
      return s.isEmpty();
    }
    boolean headMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?');

    if (p.charAt(0) == '*') {
      return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
    } else {
      return headMatch && isMatch(s.substring(1), p.substring(1));
    }
  }
}
