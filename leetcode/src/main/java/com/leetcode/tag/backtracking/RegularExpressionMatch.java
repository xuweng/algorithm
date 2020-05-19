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
     * 删除策略:删除模式串or删除匹配串?
     *
     * <p>如果没有星号（正则表达式中的 * ），问题会很简单——我们只需要从左到右检查匹配串 s 是否能匹配模式串 p 的每一个字符。
     *
     * <p>当模式串中有星号时，我们需要检查匹配串 s 中的不同后缀，以判断它们是否能匹配模式串剩余的部分。
     *
     * <p>一个直观的解法就是用回溯的方法来体现这种关系。
     *
     * <p>如果模式串中有星号，它会出现在第二个位置，即 \text{pattern[1]}pattern[1]
     * 。这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即 \text{pattern[0]}pattern[0]
     * 。如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
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

  /**
   * 不管正则符号，如果是两个普通的字符串进行比较
   *
   * @param text
   * @param pattern
   * @return
   */
  boolean isMatch1(String text, String pattern) {
    int i = 0; // text 的索引位置
    int j = 0; // pattern 的索引位置
    while (j < pattern.length()) {
      if (i >= text.length()) {
        return false;
      }
      if (pattern.charAt(j++) != text.charAt(i++)) {
        return false;
      }
    }
    // 判断 pattern 和 text 是否一样长
    return j == text.length();
  }

  /**
   * 这种匹配思路其实就是不断地减掉s或者p的可以匹配首部，直至一个或两个字符串被减为空的时候，根据最终情况来得出结论。
   */
  class s {
    public boolean isMatch(String s, String p) {
      // 如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
      if (p.isEmpty()) {
        return s.isEmpty();
      }
      // 判断s和p的首字符是否匹配，注意要先判断s不为空
      boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
      if (p.length() >= 2 && p.charAt(1) == '*') { // 如果p的第一个元素的下一个元素是*
        // 则分别对两种情况进行判断
        return isMatch(s, p.substring(2)) || (headMatched && isMatch(s.substring(1), p));
      } else if (headMatched) { // 否则，如果s和p的首字符相等
        return isMatch(s.substring(1), p.substring(1));
      } else {
        return false;
      }
    }
  }
}
