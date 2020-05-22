package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    return new ArrayList<>(re(n));
  }

  /**
   * 空间复杂度高
   *
   * <p>思路简单
   *
   * <p>老规矩
   *
   * <p>n-1-------------->n
   *
   * @param n
   * @return
   */
  public Set<String> re(int n) {
    if (n <= 1) {
      Set<String> result = new HashSet<>();
      result.add("()");

      return result;
    }

    Set<String> set = re(n - 1);
    Set<String> result = new HashSet<>();
    if (set == null || set.isEmpty()) {
      return result;
    }
    for (String s : set) {
      result.add("()" + s);
      result.add(s + "()");
      for (int i = 0; i < s.length() - 1; i++) {
        // i和i+1插入一对括号
        result.add(s.substring(0, i + 1) + "()" + s.substring(i + 1));
      }
    }

    return result;
  }
}
