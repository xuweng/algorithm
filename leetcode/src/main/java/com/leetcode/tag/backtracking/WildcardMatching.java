package com.leetcode.tag.backtracking;

/**
 * 44. 通配符匹配
 */
public class WildcardMatching {
  /**
   * 方法一：带记忆的递归 这里的第一个想法是递归，是一个较为简单的方法，但是如果输入的字符串过长会导致递归深度很大，因此比较耗时。
   *
   * <p>如果字符串相等 p == s，返回 True。 如果 p == '*'，返回 True。 如果 p 为空或 s 为空，返回 False。
   *
   * <p>若当前字符匹配，即 p[0] == s[0]
   *
   * <p>或 p[0] == '?'，然后比较下一个字符，返回 isMatch(s[1:], p[1:])。
   *
   * <p>如果当前的字符模式是一个星号 p[0] == '*'，则有两种情况。
   *
   * <p>星号没有匹配字符，因此答案是 isMatch(s, p[1:])。 星号匹配一个字符或更多字符，
   *
   * <p>因此答案是 isMatch(s[1:], p)。 若 p[0] != s[0]，返回False。
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/wildcard-matching/solution/tong-pei-fu-pi-pei-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch(String s, String p) {
    if (p == null) {
      return s == null;
    }
    if (p.equals(s)) {
      return true;
    }
    if (s == null || s.isEmpty() || p.isEmpty()) {
      return false;
    }
    boolean headMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '?';

    if (p.charAt(0) == '*') {
      boolean flag = s.length() >= 2 && p.length() >= 2 && s.charAt(1) == p.charAt(1);
      return isMatch(s, p.substring(1))
              || isMatch(s.substring(1), p)
              || flag && isMatch(s.substring(2), p.substring(2));
    } else {
      return headMatch && isMatch(s.substring(1), p.substring(1));
    }
  }
}
