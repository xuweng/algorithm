package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 */
public class GenerateParenthesis2 {
  List<String> result = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    re("", 0, 0, n);

    return result;
  }

  public void re(String temp, int left, int right, int n) {
    if (left == n && right == n) {
      result.add(temp);
      return;
    }
    if (left < right) {
      return;
    }

    if (left < n) {
      re(temp + "(", left + 1, right, n);
    }
    if (right < n) {
      re(temp + ")", left, right + 1, n);
    }
  }
}
