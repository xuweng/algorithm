package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码模板
 *
 * <p>代码模板
 *
 * <p>递归树
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>401. 二进制手表
 */
public class ReadBinaryWatch {
  /**
   * 条件太多?
   *
   * <p>基础上添加添加?
   *
   * <p>选择策略
   *
   * <p>选择策略
   *
   * <p>选择策略
   *
   * <p>选择策略
   *
   * @param num
   * @return
   */
  public List<String> readBinaryWatch(int num) {
    return null;
  }

  /**
   * 选多少个时?
   *
   * <p>选多少个分?
   *
   * @param num
   * @param list
   * @return
   */
  public List<Integer> re(int num, List<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      List<Integer> list1 = new ArrayList<>(list);
      list1.remove(i);
      List<Integer> list2 = re(num - 1, list1);
    }

    return null;
  }

  public List<Integer> init() {
    List<Integer> list = new ArrayList<>();

    // 时
    list.add(8);
    list.add(4);
    list.add(2);
    list.add(1);
    // 分
    list.add(32);
    list.add(16);
    list.add(8);
    list.add(4);
    list.add(2);
    list.add(1);

    return list;
  }
}
