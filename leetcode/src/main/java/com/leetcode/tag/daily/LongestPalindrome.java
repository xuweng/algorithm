package com.leetcode.tag.daily;

/**
 * 搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>想不出来看答案
 *
 * <p>想不出来看答案
 *
 * <p>想不出来看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>5. 最长回文子串
 */
public class LongestPalindrome {
  /**
   * 枚举每个子串
   *
   * <p>子串和子序列
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }

    int max = 0;
    int low = 0, high = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        if (valited(s, i, j)) {
          int length = j - i + 1;
          if (length > max) {
            max = length;
            low = i;
            high = j;
          }
        }
      }
    }

    return s.substring(low, high + 1);
  }

  /**
   * 注意死循环
   *
   * <p>注意死循环
   *
   * <p>注意死循环
   *
   * <p>注意死循环
   *
   * <p>注意死循环
   *
   * <p>注意死循环
   *
   * <p>注意死循环
   *
   * <p>注意死循环
   *
   * <p>代码简洁
   *
   * <p>代码易读
   *
   * @param s
   * @param i
   * @param j
   * @return
   */
  public boolean valited(String s, int i, int j) {
    int low = i;
    int high = j;

    while (low < high) {
      if (s.charAt(low) != s.charAt(high)) {
        return false;
      }
      low++;
      high--;
    }

    return low >= high;
  }
}
