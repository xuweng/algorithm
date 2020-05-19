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

  /**
   * 算法错误
   *
   * @param s
   * @return
   */
  public boolean validPalindrome1(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }

    int low = 0;
    int high = s.length() - 1;
    // 统计不相等次数
    int count = 0;
    while (low < high && count <= 1) {
      if (s.charAt(low) == s.charAt(high)) {
        low++;
        high--;
      } else {
        if (low + 1 < high && s.charAt(low + 1) == s.charAt(high)) {
          low++;
        } else if (high - 1 > low && s.charAt(low) == s.charAt(high - 1)) {
          high--;
        } else {
          return high - low <= 1;
        }
        count++;
      }
    }
    return low >= high && count <= 1;
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

  /** 使用双指针，通过贪心算法实现 */
  class Solution {
    public boolean validPalindrome(String s) {
      int low = 0, high = s.length() - 1;
      while (low < high) {
        char c1 = s.charAt(low), c2 = s.charAt(high);
        if (c1 == c2) {
          low++;
          high--;
        } else {
          boolean flag1 = true, flag2 = true;
          for (int i = low, j = high - 1; i < j; i++, j--) {
            char c3 = s.charAt(i), c4 = s.charAt(j);
            if (c3 != c4) {
              flag1 = false;
              break;
            }
          }
          for (int i = low + 1, j = high; i < j; i++, j--) {
            char c3 = s.charAt(i), c4 = s.charAt(j);
            if (c3 != c4) {
              flag2 = false;
              break;
            }
          }
          return flag1 || flag2;
        }
      }
      return true;
    }
  }

  class Solution1 {
    public boolean checkPalindrome(String s, int low, int high) {
      for (int i = low, j = high; i < j; ++i, --j) {
        if (s.charAt(i) != s.charAt(j)) {
          return false;
        }
      }
      return true;
    }

    public boolean validPalindrome(String s) {
      for (int low = 0, high = s.length() - 1; low < high; ++low, --high) {
        char c1 = s.charAt(low), c2 = s.charAt(high);
        if (c1 != c2) {
          return checkPalindrome(s, low, high - 1) || checkPalindrome(s, low + 1, high);
        }
      }
      return true;
    }
  }

  class Solution2 {
    public boolean palindrome(String s, int i, int j) {
      while (i < j && s.charAt(i) == s.charAt(j)) {
        ++i;
        --j;
      }
      return i >= j;
    }

    boolean validPalindrome(String s) {
      int i = 0, j = s.length() - 1;
      while (i < j && s.charAt(i) == s.charAt(j)) {
        ++i;
        --j;
      }
      return palindrome(s, i, j - 1) || palindrome(s, i + 1, j);
    }
  }

  class Solution3 {
    public boolean validPalindrome(String s) {
      if (s == null || s.length() == 0) {
        return false;
      }
      return re(s, 0, s.length() - 1);
    }

    public boolean re(String s, int low, int high) {
      if (s.length() <= 2) {
        return true;
      }
      if (low > high) {
        return false;
      }
      boolean b = s.charAt(low) == s.charAt(high);
      if (high - low <= 1) {
        return b;
      }

      return b ? re(s, low + 1, high - 1) : re(s, low, high - 1) || re(s, low + 1, high);
    }

    public boolean palindrome(String s, int i, int j) {
      while (i < j && s.charAt(i) == s.charAt(j)) {
        ++i;
        --j;
      }
      return i >= j;
    }
  }
}
