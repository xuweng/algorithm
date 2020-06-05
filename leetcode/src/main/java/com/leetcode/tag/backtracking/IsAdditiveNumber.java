package com.leetcode.tag.backtracking;

/**
 * 写算法
 *
 * <p>先写一个框架,再补充细节
 *
 * <p>306. 累加数
 */
public class IsAdditiveNumber {
  public boolean isAdditiveNumber(String num) {
    return backTrack(num, 0, 1);
  }

  public boolean backTrack(String num, int start, int count) {
    if (count >= num.length() - start - 1) {
      return false;
    }
    for (int i = start; i < num.length() - 2; i++) {
      int sum = Integer.parseInt(String.valueOf(num.charAt(i))) + get(num, i, count);
      int[] index = getIndex(num, sum, i, count);
      if (index[0] == -1) {
        continue;
      }
      return backTrack(num, i, count + 1);
    }
    return true;
  }

  public int get(String num, int start, int count) {
    return Integer.parseInt(num.substring(start + 1, start + count + 1));
  }

  public int[] getIndex(String num, int sum, int start, int count) {
    int index = -1;
    int value = -1;
    for (int i = start + count + 1; i < num.length(); i++) {
      int i1 = Integer.parseInt(num.substring(start + count + 1, i + 1));
      if (sum == i1) {
        index = i;
        value = i1;
      }
    }

    return new int[]{index, value};
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
