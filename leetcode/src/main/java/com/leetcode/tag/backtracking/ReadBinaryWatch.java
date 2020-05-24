package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-watch/solution/czong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-d/
 *
 * <p>因此回溯算法与DFS的区别就是有无状态重置
 *
 * <p>2.何时使用回溯算法 **
 *
 * <p>当问题需要"回头"，以此来查找出所有的解的时候**，使用回溯算法。
 *
 * <p>即满足结束条件或者发现不是正确路径的时候(走不通)，要撤销选择，回退到上一个状态，继续尝试，直到找出所有解为止
 *
 * <p>3.怎么样写回溯算法(从上而下，※代表难点，根据题目而变化)
 *
 * <p>①画出递归树，找到状态变量(回溯函数的参数)，这一步非常重要※
 *
 * <p>②根据题意，确立结束条件
 *
 * <p>③找准选择列表(与函数参数相关),与第一步紧密关联※
 *
 * <p>④判断是否需要剪枝
 *
 * <p>⑤作出选择，递归调用，进入下一层
 *
 * <p>⑥撤销选择
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
   * 需要的东西太多
   *
   * <p>需要个数、需要和
   *
   * <p>选多少个时?
   *
   * <p>选多少个分?
   *
   * @param num
   * @param list
   * @return
   */
  public List<Integer> re(int i, int j) {
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
