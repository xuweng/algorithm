package com.leetcode.tag.must2.seven;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 03.02. 栈的最小值
 */
public class MinStack {
    Deque<Integer> deque;
    Deque<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        deque = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        deque.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            min.push(min.peek() < x ? min.peek() : x);
        }
    }

    public void pop() {
        deque.pop();
        min.pop();
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return min.peek();
    }

    class MinStack1 {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack1() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            // 哨兵
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            // Math
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
