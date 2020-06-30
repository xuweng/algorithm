package com.leetcode.tag.daily;

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

  public void appendTail(int value) {
    stack1.push(value);
  }

  public int deleteHead() {
    // 如果第二个栈为空
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    if (stack2.isEmpty()) {
      return -1;
    } else {
      return stack2.pop();
    }
  }
}
