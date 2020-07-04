package com.leetcode.tag.daily;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 *
 * <p>最长?dp?
 *
 * <p>枚举所有子串?
 */
public class LongestValidParentheses {
  public int longestValidParentheses(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String str = s.substring(i, j + 1);
        if (check(str)) {
          max = Math.max(max, str.length());
        }
      }
    }
    return max;
  }

  public boolean check(String s) {
    if (s.charAt(0) == ')') {
      return false;
    }
    Deque<Character> stack = new LinkedList<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        stack.pop();
      }
    }

    return stack.isEmpty();
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public class Solution {
    /**
     * 状态定义：以下标i结尾
     *
     * <p>不太容易理解
     *
     * <p>不太容易理解
     *
     * <p>状态转移方程不太容易理解
     *
     * <p>我们定义 dp[i] 表示以下标 i 字符结尾的最长有效括号的长度。我们将 dp 数组全部初始化为 0 。
     *
     * <p>显然有效的子串一定以‘)’ 结尾，因此我们可以知道以 ‘(’ 结尾的子串对应的 dp 值必定为 0 ，
     *
     * <p>我们只需要求解‘)’ 在dp 数组中对应位置的值。
     *
     * <p>形如“……()”，我们可以推出：
     *
     * <p>dp[i]=dp[i−2]+2
     *
     * <p>形如 “……))”
     *
     * <p>dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
      int maxans = 0;
      int dp[] = new int[s.length()];
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == ')') {
          if (s.charAt(i - 1) == '(') {
            // 形如“……()”，我们可以推出：
            dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
          } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
            // 形如 “……))”
            dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
          }
          maxans = Math.max(maxans, dp[i]);
        }
      }
      return maxans;
    }
  }
}
