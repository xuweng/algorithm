package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>所有方案
 *
 * <p>所有方案
 *
 * <p>root到叶子结点就是一个解
 */
public class Permutation {
  // 保存路径
  private List<Character> temp = new ArrayList<Character>();
  private Set<String> res = new HashSet<>();

  public String[] permutation(String S) {
    if (S == null) {
      return new String[]{};
    }
    if (S.length() == 1) {
      return new String[]{S};
    }

    re(S);

    return res.toArray(new String[0]);
  }

  public void re(String s) {
    if (s == null) {
      return;
    }
    if ("".equalsIgnoreCase(s)) {
      // 添加一条路径
      StringBuilder sb = new StringBuilder();
      temp.forEach(sb::append);

      res.add(sb.toString());
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      temp.add(s.charAt(i));

      re(delete(s, i));

      temp.remove(temp.size() - 1);
    }
  }

  /**
   * 删除index字符
   *
   * @param s
   * @param index
   * @return
   */
  public String delete(String s, int index) {
    if (s.length() == 1) {
      return "";
    }
    // 删除最后一个字符
    if (index == s.length() - 1) {
      return s.substring(0, index);
    }
    char[] chars = new char[s.length() - 1];
    System.arraycopy(s.toCharArray(), index + 1, chars, index, s.length() - 1 - index);

    return new String(chars);
  }
}
