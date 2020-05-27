package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 */
public class GetHappyString {
  public String getHappyString(int n, int k) {
    char[] chars = {'a', 'b', 'c'};

    // 使用result保存结果集
    List<String> result = new ArrayList<>();

    backTrack(chars, n, ' ', "", result);

    return result.size() >= k ? result.get(k - 1) : "";
  }

  public void backTrack(char[] chars, int n, char select, String temp, List<String> result) {
    if (n == 0) {
      result.add(temp);
      return;
    }

    for (char c : chars) {
      if (select == c) {
        continue;
      }
      backTrack(chars, n - 1, c, temp + c, result);
    }
  }
}
