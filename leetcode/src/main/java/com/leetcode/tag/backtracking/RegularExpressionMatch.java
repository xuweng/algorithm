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
    /**
     * 如果没有星号（正则表达式中的 * ），问题会很简单——我们只需要从左到右检查匹配串 s 是否能匹配模式串 p 的每一个字符。
     *
     * <p>当模式串中有星号时，我们需要检查匹配串 s 中的不同后缀，以判断它们是否能匹配模式串剩余的部分。
     *
     * <p>一个直观的解法就是用回溯的方法来体现这种关系。
     *
     * @param text
     * @param pattern
     * @return
     */
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
