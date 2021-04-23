package com.leetcode.tag.must1.six;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 30. 包含min函数的栈
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
            min.push(min.peek() > x ? x : min.peek());
        }
    }

    public void pop() {
        deque.pop();
    }

    public int top() {
        return deque.peek();
    }

    public int min() {
        return min.peek();
    }
}
