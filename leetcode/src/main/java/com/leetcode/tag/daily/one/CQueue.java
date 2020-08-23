package com.leetcode.tag.daily.one;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * <p>维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
 *
 * <p>作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class CQueue {
  Deque<Integer> stack1;
  Deque<Integer> stack2;

  public CQueue() {
    stack1 = new LinkedList<>();
    stack2 = new LinkedList<>();
  }

  /**
   * 第一个栈支持插入操作
   *
   * @param value
   */
  public void appendTail(int value) {
    stack1.push(value);
  }

  /**
   * 图解。图解。图解。图解。图解。图解
   *
   * <p>第二个栈支持删除操作
   *
   * @return
   */
  public int deleteHead() {
    // 如果第二个栈为空
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        // 第一个栈的元素全部迁移到第二个栈
        stack2.push(stack1.pop());
      }
    }
    return stack2.isEmpty() ? -1 : stack2.pop();
  }
}
