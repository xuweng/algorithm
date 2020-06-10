package com.leetcode.tag.daily;

/**
 * 9. 回文数
 */
public class IsPalindrome {
  public boolean isPalindrome(int x) {
    String str = String.valueOf(x);
    return re(str, 0, str.length() - 1);
  }

  public boolean re(String x, int start, int end) {
    if (start == end) {
      return true;
    }
    final boolean isTrue = x.charAt(start) == x.charAt(end);
    if (end - start == 1) {
      return isTrue;
    }
    return isTrue && re(x, start + 1, end - 1);
  }
}
