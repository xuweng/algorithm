package com.leetcode.tag.divide;

import java.util.ArrayList;
import java.util.List;

/**
 * 审题
 *
 * <p>审题.审题.审题
 *
 * <p>防止
 *
 * <p>链表断开
 *
 * <p>282. 给表达式添加运算符
 */
public class ExpressionAddOperators {
  public List<String> addOperators(String num, int target) {
    return divide(num, num.length() - 1, target);
  }

  /**
   * 假设计算出n-1 的target和string
   *
   * <p>需要子问题的解,需要处理子问题的解
   *
   * <p>不需要处理子问题的解
   *
   * <p>需要处理子问题的解
   *
   * <p>小数据规模验证
   *
   * @param num
   * @param n
   * @param target
   * @return
   */
  public List<String> divide(String num, int n, int target) {
    if (n <= 0) {
      List<String> list = new ArrayList<>();
      list.add(String.valueOf(num.charAt(n)));
      return list;
    }
    // 第n个数
    int i = Integer.parseInt(String.valueOf(num.charAt(n)));
    if (i >= target) {
      // 计算前n-1
      // 前n-1 - i
      List<String> list = divide(num, n - 1, i + target);

      // 处理list
      List<String> list1 = new ArrayList<>();
      for (String s : list) {
        list1.add(s + "-" + i);
      }
      return list1;
    } else {
      // 前n-1 + i
      List<String> list1 = divide(num, n - 1, target - i);
      List<String> list2 = new ArrayList<>();
      for (String s : list1) {
        list2.add(s + "+" + i);
      }
      // 前n-1 * i
      if (target % i == 0) {
        List<String> list3 = new ArrayList<>();
        List<String> list4 = divide(num, n - 1, target / i);
        for (String s : list4) {
          list3.add(s + "*" + i);
        }
        list2.addAll(list3);
      }
      return list2;
    }
  }
}
