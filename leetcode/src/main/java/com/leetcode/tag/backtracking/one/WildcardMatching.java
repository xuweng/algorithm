package com.leetcode.tag.backtracking.one;

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
    if (p.equals(s) || "*".equals(p)) {
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

  /**
   * 第一种方法中的记忆给出了尝试动态规划的想法。这个问题和编辑距离非常相似，所以我们在这里使用完全相同的方法。
   *
   * <p>我们的想法是将问题简化为简单的问题，例如，有一个字符串 adcebdk 和字符模式 *a*b?k，
   *
   * <p>计算是否匹配 D = True/False。我们将输入字符串和字符模式的长度
   *
   * <p>p_len，s_len 和是否匹配 D[p_len][s_len] 联系起来。
   *
   * <p>让我们进一步介绍 D[p_idx][s_idx]，D[p_idx][s_idx] 代表的是字符模式中的第 p_idx 字符和输入字符串的第 s_idx字符是否匹配。
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/wildcard-matching/solution/tong-pei-fu-pi-pei-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean isMatch(String s, String p) {
      int sLen = s.length(), pLen = p.length();

      // base cases
      if (p.equals(s) || "*".equals(p)) {
        return true;
      }
      if (p.isEmpty() || s.isEmpty()) {
        return false;
      }

      // init all matrix except [0][0] element as False
      boolean[][] d = new boolean[pLen + 1][sLen + 1];
      d[0][0] = true;

      // DP compute
      for (int pIdx = 1; pIdx < pLen + 1; pIdx++) {
        // the current character in the pattern is '*'
        if (p.charAt(pIdx - 1) == '*') {
          int sIdx = 1;
          // d[p_idx - 1][s_idx - 1] is a string-pattern match
          // on the previous step, i.e. one character before.
          // Find the first idx in string with the previous math.
          while ((!d[pIdx - 1][sIdx - 1]) && (sIdx < sLen + 1)) {
            sIdx++;
          }
          // If (string) matches (pattern),
          // when (string) matches (pattern)* as well
          d[pIdx][sIdx - 1] = d[pIdx - 1][sIdx - 1];
          // If (string) matches (pattern),
          // when (string)(whatever_characters) matches (pattern)* as well
          while (sIdx < sLen + 1) {
            d[pIdx][sIdx++] = true;
          }
        }
        // the current character in the pattern is '?'
        else if (p.charAt(pIdx - 1) == '?') {
          System.arraycopy(d[pIdx - 1], 0, d[pIdx], 1, sLen + 1 - 1);
        }
        // the current character in the pattern is not '*' or '?'
        else {
          for (int sIdx = 1; sIdx < sLen + 1; sIdx++) {
            // Match is possible if there is a previous match
            // and current characters are the same
            d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] && (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
          }
        }
      }
      return d[pLen][sLen];
    }
  }
}
