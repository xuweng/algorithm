package com.leetcode.tag.daily;

/**
 * 680. 验证回文字符串 Ⅱ
 */
public class ValidPalindrome {
  /**
   * 超出时间限制
   *
   * @param s
   * @return
   */
  public boolean validPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }
    boolean valid = isHui(s, 0, s.length() - 1);
    for (int i = 0; i < s.length() && !valid; i++) {
      String s1 = delete(s, i);
      valid = valid || isHui(s1, 0, s1.length() - 1);
    }

    return valid;
  }

  public boolean validPalindrome1(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }

    int low = 0;
    int high = s.length() - 1;
    while (low < high) {
      if (s.charAt(low) == s.charAt(high)) {

        low++;
        high--;
      } else {
        return high - low <= 1;
      }
    }
    return true;
  }

  public boolean isHui(String s, int low, int high) {
    if (s == null || low > high) {
      return false;
    }
    // 递归终止条件
    if (low == high) {
      return true;
    }
    boolean b = s.charAt(low) == s.charAt(high);
    if (high - low == 1) {
      return b;
    }

    return b && isHui(s, low + 1, high - 1);
  }

  public String delete(String s, int index) {
    if (s.length() == 1) {
      return "";
    }
    // 删除最后一个字符
    if (index == s.length() - 1) {
      return s.substring(0, index);
    }
    char[] chars = s.toCharArray();
    if (s.length() - 1 - index >= 0) {
      System.arraycopy(chars, index + 1, chars, index, s.length() - 1 - index);
    }
    char[] result = new char[s.length() - 1];
    if (chars.length - 1 >= 0) {
      System.arraycopy(chars, 0, result, 0, chars.length - 1);
    }

    return new String(result);
  }
}
