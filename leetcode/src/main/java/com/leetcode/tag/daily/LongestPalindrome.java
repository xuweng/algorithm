package com.leetcode.tag.daily;

/**
 * 大神熟练
 *
 * <p>大神熟练
 *
 * <p>大神熟练
 *
 * <p>大神熟练
 *
 * <p>大神熟练
 *
 * <p>大神熟练
 *
 * <p>大神熟练
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
   * 找规律
   *
   * <p>找规律
   *
   * <p>找规律
   *
   * <p>找规律
   *
   * <p>找规律
   *
   * <p>找规律
   *
   * <p>找规律
   *
   * <p>找规律
   *
   * <p>找规律
   *
   * <p>找规律
   *
   * <p>枚举每个子串
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

    return true;
  }

  /**
   * 原问题:最长的回文子串
   *
   * <p>我们用 P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串（下文表示成 s[i:j]）是否为回文串：
   *
   * <p>状态定义不是根据原问题
   *
   * <p>dp状态定义
   *
   * @param s
   * @return
   */
  public String dp(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }

    boolean[][] dp = new boolean[s.length()][s.length()];
    // 初始化对角线
    for (int i = 0; i < dp.length; i++) {
      dp[i][i] = true;
    }
    int max = 0;
    int low = 0, high = 0;
    // 按行计算--------固定行
    // 按列计算--------固定列
    for (int right = 1; right < dp.length; right++) {
      for (int left = 0; left < right; left++) {
        boolean b = s.charAt(left) == s.charAt(right);
        dp[left][right] = right - left == 1 ? b : b && dp[left + 1][right - 1];
        if (dp[left][right]) {
          int length = right - left + 1;
          if (length > max) {
            max = length;
            low = left;
            high = right;
          }
        }
      }
    }

    return s.substring(low, high + 1);
  }
}
