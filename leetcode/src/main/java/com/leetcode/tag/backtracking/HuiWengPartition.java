package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 求最优解太舒服了
 *
 * <p>求所有方案太难
 *
 * <p>所有方案?最优解?
 *
 * <p>所有可能的分割方案?
 *
 * <p>分割最少次数?
 *
 * <p>所有方案
 *
 * <p>分割最少次数?
 *
 * <p>不是求最优解
 *
 * <p>如何划分?
 *
 * <p>一次两两划分?
 *
 * <p>多次划分?
 *
 * <p>划分后需要递归?
 *
 * <p>131. 分割回文串
 *
 * <p>两两划分后,发现横跨mid的字符串就是原问题,横跨mid的字符串难求
 *
 * <p>能不能两两划分,就看能不能计算横跨mid这部分
 */
public class HuiWengPartition {
  public List<List<String>> partition(String s) {
    if (s == null) {
      return new ArrayList<>();
    }
    return re(s, 0, s.length() - 1);
  }

  public List<List<String>> re(String s, int low, int high) {
    if (low > high) {
      return null;
    }
    List<List<String>> lists = new ArrayList<>();
    if (low == high) {
      List<String> list = new ArrayList<>();
      list.add(s.substring(low, high + 1));
      lists.add(list);
      return lists;
    }
    for (int i = low; i < high; i++) {
      if (isHui(s, low, i)) {
        String left = s.substring(low, i + 1);
        List<List<String>> right = re(s, i + 1, high);
        for (List<String> list : right) {
          List<String> list1 = new ArrayList<>();
          list1.add(left);
          list1.addAll(list);
          lists.add(list1);
        }
      }
    }
    if (isHui(s, low, high)) {
      List<String> list = new ArrayList<>();
      list.add(s.substring(low, high + 1));
      lists.add(list);
    }

    return lists;
  }

  public boolean isHui(String s, int low, int high) {
    if (s == null || low > high) {
      return false;
    }
    // 递归终止条件
    if (low == high) {
      return true;
    }
    boolean b = s.charAt(low) == s.charAt(high);
    if (high - low == 1) {
      return b;
    }

    return b && isHui(s, low + 1, high - 1);
  }

  class Solution {
    private List<String> temp = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
      char[] chars = s.toCharArray();
      dopart(chars, 0, chars.length - 1);
      return res;
    }

    public void dopart(char[] chars, int i, int j) {
      if (i > j) {
        res.add(new ArrayList<>(temp));
        return;
      }
      for (int k = i; k <= j; k++) {
        if (isPalindrome(chars, i, k)) {
          temp.add(new String(chars, i, k - i + 1));
          dopart(chars, k + 1, j);
          temp.remove(temp.size() - 1);
        }
      }
    }

    /**
     * 是否是回文
     *
     * @param chars
     * @param i
     * @param j
     * @return
     */
    public boolean isPalindrome(char[] chars, int i, int j) {
      if (i == j) {
        return true;
      }
      while (i <= j) {
        if (chars[i] != chars[j]) {
          return false;
        }
        i++;
        j--;
      }
      return true;
    }
  }
}
