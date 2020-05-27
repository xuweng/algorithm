package com.leetcode.tag.backtracking;

/**
 * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 */
public class GetHappyString {
  int count;

  public String getHappyString(int n, int k) {
    char[] chars = {'a', 'b', 'c'};

    return backTrack(chars, n, k, ' ', "");
  }

  public String backTrack(char[] chars, int n, int K, char select, String temp) {
    if (n == 0) {
      count++;
      return count == K ? temp : "";
    }

    for (char c : chars) {
      if (select == c) {
        continue;
      }
      return backTrack(chars, n - 1, K, c, temp + c);
    }
    return "";
  }
}
