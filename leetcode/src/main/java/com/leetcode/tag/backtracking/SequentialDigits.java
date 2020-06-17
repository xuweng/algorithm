package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. 顺次数
 *
 * <p>用参数来计算
 *
 * <p>用参数来计算
 *
 * <p>用参数来计算
 *
 * <p>用参数来计算
 *
 * <p>用参数来计算
 *
 * <p>用参数来计算
 */
public class SequentialDigits {
  private List<Integer> result;

  public List<Integer> sequentialDigits(int low, int high) {
    result = new ArrayList<>();

    backTrack(low, high, 1, "");

    return result;
  }

  /**
   * 用参数来计算
   *
   * @param low
   * @param high
   * @param start
   * @param temp
   */
  public void backTrack(int low, int high, int start, String temp) {
    if (temp.length() > 0) {
      int i = Integer.parseInt(temp);
      if (check(low, high, temp)) {
        result.add(i);
      }
      if (i > high) {
        return;
      }
    }

    for (int i = start; i <= 9; i++) {
      backTrack(low, high, i + 1, temp + i);
    }
  }

  private boolean check(int low, int high, String temp) {
    int i = Integer.parseInt(temp);
    if (i >= low && i <= high) {
      char[] chars = temp.toCharArray();
      int value = Integer.parseInt(String.valueOf(chars[0]));
      for (int j = 1; j < chars.length; j++) {
        if (value + 1 != Integer.parseInt(String.valueOf(chars[j]))) {
          return false;
        }
        value = chars[j];
      }
      return true;
    }
    return false;
  }
}
