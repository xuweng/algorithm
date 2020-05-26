package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 357. 计算各个位数不同的数字个数
 */
public class CountNumbersWithUniqueDigits {
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 1) {
      return 10;
    }
    return (int) Math.pow(10, n) - re(n).size();
  }

  public List<String> re(int n) {
    if (n == 2) {
      List<String> result = new ArrayList<>();
      for (int i = 1; i <= 9; i++) {
        result.add(String.valueOf(i) + i);
      }
      return result;
    }

    List<String> result = new ArrayList<>();
    List<String> list = re(n - 1);
    if (list == null) {
      return result;
    }
    for (String s : list) {
      for (int i = 0; i <= 9; i++) {
        result.add(s + i);
      }
    }
    return result;
  }
}
