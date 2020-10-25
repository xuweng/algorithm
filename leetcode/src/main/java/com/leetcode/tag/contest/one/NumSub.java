package com.leetcode.tag.contest.one;

/**
 * 5461. 仅含 1 的子串数
 */
public class NumSub {
  /**
   * s[i] == '0' 或 s[i] == '1'
   *
   * <p>1 <= s.length <= 10^5
   */
  class Solution {
    public int numSub(String s) {
      if (s == null || s.length() == 0) {
        return 0;
      }
      long result = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0') {
          continue;
        }
        int j = i;
        while (j < s.length() && s.charAt(j) == '1') {
          j++;
        }
        result += sum(j - i);
        i = j;
      }
      return (int) (result % (Math.pow(10, 9) + 7));
    }

    private long sum(int count) {
      long sum = 0;
      for (long i = 1; i <= count; i++) {
        sum += i;
      }
      return sum;
    }
  }
}
