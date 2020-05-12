package com.leetcode.tag.divide;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 155. 最小栈
 *
 * <p>设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */
class MinStack {
  private List<Integer> list;
  private int min;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    min = Integer.MAX_VALUE;
    list = new ArrayList<>();
  }

  public void push(int x) {
    list.add(x);
    min = Math.min(min, x);
  }

  public void pop() {
    if (list.isEmpty()) {
      return;
    }
    // remove后min会发生改变
    int o = list.remove(list.size() - 1);
    if (min != o) {
      return;
    }
    min = list.stream().min(Comparator.comparing(Integer::valueOf)).orElse(Integer.MAX_VALUE);
  }

  public int top() {
    if (list.isEmpty()) {
      return 0;
    }
    return list.get(list.size() - 1);
  }

  public int getMin() {
    if (list.isEmpty()) {
      return 0;
    }
    return min;
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
