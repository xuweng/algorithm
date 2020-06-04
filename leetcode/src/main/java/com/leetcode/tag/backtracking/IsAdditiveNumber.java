package com.leetcode.tag.backtracking;

import java.util.Arrays;

/**
 * 写算法
 *
 * <p>先写一个框架,再补充细节
 *
 * <p>306. 累加数
 */
public class IsAdditiveNumber {
  public boolean isAdditiveNumber(String num) {
    return backTrack(num, 0, 0);
  }

  public boolean backTrack(String num, int start, int count) {
    if (count >= num.length() - start - 1) {
      return false;
    }
    for (int i = start; i < num.length() - 2; i++) {
      int sum = Integer.parseInt(String.valueOf(num.charAt(i))) + get(num, i, count);
      if (isMatch(num, sum, start, count)) {
        continue;
      }
      return backTrack(num, i, count + 1);
    }
    return true;
  }

  public int get(String num, int start, int count) {
    if (count == 0) {
      return Integer.parseInt(num.substring(start + 1, start + 2));
    }
    return Integer.parseInt(num.substring(start + 1, start + count + 1));
  }

  public boolean isMatch(String num, int sum, int start, int count) {
    return Arrays.stream(getNum(num, start + count + 1)).anyMatch(i -> sum == i);
  }

  public int[] getNum(String num, int start) {
    int[] nums = new int[num.length() - start];
    int index = 0;
    for (int i = start; i < num.length(); i++) {
      nums[index++] = Integer.parseInt(num.substring(start, i + 1));
    }

    return nums;
  }
}
