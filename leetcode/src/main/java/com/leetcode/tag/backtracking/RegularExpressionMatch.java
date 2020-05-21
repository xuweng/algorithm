package com.leetcode.tag.backtracking;

/**
 * 拿几个测试用例试一下,没搞懂题目
 *
 * <p>证明算法正确性
 *
 * <p>证明算法正确性
 *
 * <p>证明算法正确性
 *
 * <p>证明算法正确性
 *
 * <p>证明算法正确性
 *
 * <p>正则表达式匹配
 *
 * <p>'.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素
 *
 * <p>匹配零个表示把前面那个元素干掉
 *
 * <p>所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class RegularExpressionMatch {
  public boolean isMatch(String s, String p) {
    if (p == null) {
      return s == null;
    }
    if (p.isEmpty()) {
      return s.isEmpty();
    }
    if (s.isEmpty()) {
      return p.isEmpty();
    }

    boolean firstMatch = s.charAt(0) == p.charAt(0);

    // p第1个字符是否是*
    boolean pNext = p.length() >= 2 && p.charAt(1) == '*';
    if (pNext) {
      if (firstMatch) {
        int i = 0;
        while (i < s.length() && ((s.charAt(0) == s.charAt(i)) || p.charAt(0) == '.')) {
          i++;
        }
        if (i == s.length()) {
          return true;
        }
        return isMatch(s.substring(i), p.substring(2));

      } else {
        return isMatch(s, p.substring(2));
      }
    } else {
      return (firstMatch || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
    }
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
      // 首字符是否匹配
      boolean firstMatch =
              (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

      if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
        // pattern的第1个元素是*
        // 直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符
        // 难点.干掉text字符或者干掉pattern字符?
        // 保持text不变，将pattern的减掉两个元素;相等则保持pattern不变，text减掉首元素
        //        return firstMatch
        //                ? isMatch(text.substring(1), pattern)
        //                : isMatch(text, pattern.substring(2));
        return (isMatch(text, pattern.substring(2))
                || (firstMatch && isMatch(text.substring(1), pattern)));
      } else {
        // pattern的第1个元素不是*
        // 常规比较
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

  /** 这种匹配思路其实就是不断地减掉s或者p的可以匹配首部，直至一个或两个字符串被减为空的时候，根据最终情况来得出结论。 */
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

  /**
   * 自顶向下的方法
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    // 缓存子问题的解
    Boolean[][] memo;

    /**
     * dp[i][j]就是s的前i个元素是否可以被p的前j个元素所匹配。
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch(String text, String pattern) {
      memo = new Boolean[text.length() + 1][pattern.length() + 1];
      return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
      if (memo[i][j] != null) {
        return memo[i][j];
      }
      boolean ans;
      if (j == pattern.length()) {
        ans = i == text.length();
      } else {
        boolean firstMatch =
                (i < text.length()
                        && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
          ans = (dp(i, j + 2, text, pattern) || firstMatch && dp(i + 1, j, text, pattern));
        } else {
          ans = firstMatch && dp(i + 1, j + 1, text, pattern);
        }
      }
      memo[i][j] = ans;
      return ans;
    }
  }

  /**
   * 自底向上的方法
   */
  class Solution2 {
    public boolean isMatch(String text, String pattern) {
      boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
      dp[text.length()][pattern.length()] = true;

      for (int i = text.length(); i >= 0; i--) {
        for (int j = pattern.length() - 1; j >= 0; j--) {
          boolean firstMatch =
                  (i < text.length()
                          && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
          if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
          } else {
            dp[i][j] = firstMatch && dp[i + 1][j + 1];
          }
        }
      }
      return dp[0][0];
    }
  }

  class c1 {
    public boolean isMatch(String s, String p) {
      // 需要分别取出s和p为空的情况，所以dp数组大小+1
      boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
      // 初始化dp[0][0]=true,dp[0][1]和dp[1][0]~dp[s.length][0]默认值为false所以不需要显式初始化
      dp[0][0] = true;
      // 填写第一行dp[0][2]~dp[0][p.length]
      for (int k = 2; k <= p.length(); k++) {
        // p字符串的第2个字符是否等于'*',此时j元素需要0个，所以s不变p减除两个字符
        dp[0][k] = p.charAt(k - 1) == '*' && dp[0][k - 2];
      }
      // 填写dp数组剩余部分
      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
          // p第j个字符是否为*
          if (p.charAt(j) == '*') {
            // 两种情况:1.s不变[i+1],p移除两个元素[j+1-2]。
            // 2.比较s的i元素和p的j-1(因为此时j元素为*)元素,相等则移除首元素[i+1-1],p不变。
            dp[i + 1][j + 1] = dp[i + 1][j - 1] || (dp[i][j + 1] && headMatched(s, p, i, j - 1));
          } else {
            // s的i元素和p的j元素是否相等,相等则移除s的i元素[i+1-1]和p的j元素[j+1-1]
            dp[i + 1][j + 1] = dp[i][j] && headMatched(s, p, i, j);
          }
        }
      }
      return dp[s.length()][p.length()];
    }

    /**
     * 判断s第i个字符和p第j个字符是否匹配
     *
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    public boolean headMatched(String s, String p, int i, int j) {
      return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }
  }
}
