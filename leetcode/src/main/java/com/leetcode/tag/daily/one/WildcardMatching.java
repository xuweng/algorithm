package com.leetcode.tag.daily.one;

/**
 * 44. 通配符匹配
 */
public class WildcardMatching {
  class Solution {
    public boolean isMatch(String s, String p) {
      if (p == null) {
        return s == null;
      }
      if (p.isEmpty()) {
        return s.isEmpty();
      }
      boolean headMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?');

      if (p.charAt(0) == '*') {
        boolean flag = s.length() >= 2 && p.length() >= 2 && s.charAt(1) == p.charAt(1);
        return isMatch(s, p.substring(1))
                || (s.length() >= 1 && isMatch(s.substring(1), p))
                || (flag && isMatch(s.substring(2), p.substring(2)));
      } else {
        return headMatch && isMatch(s.substring(1), p.substring(1));
      }
    }
  }

  /**
   * 方法一：动态规划 思路与算法
   *
   * <p>在给定的模式 p 中，只会有三种类型的字符出现：
   *
   * <p>小写字母 a−z，可以匹配对应的一个小写字母；
   *
   * <p>问号 ?，可以匹配任意一个小写字母；
   *
   * <p>星号 ∗，可以匹配任意字符串，可以为空，也就是匹配零或任意多个小写字母。
   *
   * <p>其中「小写字母」和「问号」的匹配是确定的，而「星号」的匹配是不确定的，因此我们需要枚举所有的匹配情况。
   *
   * <p>为了减少重复枚举，我们可以使用动态规划来解决本题。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/wildcard-matching/solution/tong-pei-fu-pi-pei-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * 两个字符串的状态定义
     *
     * <p>原问题很明显。原问题很明显。原问题很明显。原问题很明显。
     *
     * <p>我们用dp[i][j] 表示字符串 s 的前 i 个字符和模式 p 的前 j 个字符是否能匹配
     *
     * <p>在进行状态转移时，我们可以考虑模式 p 的第 j 个字符 p_j ​ ，与之对应的是字符串 s 中的第 i 个字符 s_i：
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
      int m = s.length();
      int n = p.length();
      boolean[][] dp = new boolean[m + 1][n + 1];
      dp[0][0] = true;
      for (int i = 1; i <= n; ++i) {
        if (p.charAt(i - 1) == '*') {
          dp[0][i] = true;
        } else {
          break;
        }
      }
      for (int i = 1; i <= m; ++i) {
        for (int j = 1; j <= n; ++j) {
          if (p.charAt(j - 1) == '*') {
            dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
          } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
          }
        }
      }
      return dp[m][n];
    }
  }
}
