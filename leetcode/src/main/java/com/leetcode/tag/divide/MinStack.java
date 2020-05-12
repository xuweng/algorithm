package com.leetcode.tag.divide;

import java.util.Stack;

/**
 * 155. 最小栈
 *
 * <p>设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */
class MinStack {
  // 栈
  private Stack<Integer> stack;
  // 每个元素 a 与其相应的最小值 m 时刻保持一一对应。因此我们可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值
  private Stack<Integer> minStack;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
    minStack.push(Integer.MAX_VALUE);
  }

  /**
   * 当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
   *
   * <p>当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
   *
   * <p>在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param x
   */
  public void push(int x) {
    stack.push(x);
    minStack.push(Math.min(x, minStack.peek()));
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

  class MinStack1 {
    private Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
    }

    public void push(int x) {
      if (head == null) {
        head = new Node(x, x);
      } else {
        head = new Node(x, Math.min(x, head.min), head);
      }
    }

    public void pop() {
      head = head.next;
    }

    public int top() {
      return head.val;
    }

    public int getMin() {
      return head.min;
    }

    private class Node {
      int val;
      // 最小值
      int min;
      Node next;

      private Node(int val, int min) {
        this(val, min, null);
      }

      private Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
      }
    }
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
