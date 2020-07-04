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
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
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
}
