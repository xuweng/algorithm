package com.leetcode.tag.backtracking;

/**
 * 正则表达式匹配
 */
public class RegularExpressionMatch {
  public boolean isMatch(String s, String p) {
    return s.matches(p);
  }

  /**
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean isMatch(String text, String pattern) {
      if (pattern.isEmpty()) {
        return text.isEmpty();
      }
      boolean firstMatch =
              (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

      if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
        return (isMatch(text, pattern.substring(2))
                || (firstMatch && isMatch(text.substring(1), pattern)));
      } else {
        return firstMatch && isMatch(text.substring(1), pattern.substring(1));
      }
    }
  }
}
