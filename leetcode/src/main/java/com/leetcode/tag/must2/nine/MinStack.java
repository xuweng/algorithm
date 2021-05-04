package com.leetcode.tag.must2.nine;

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
        // 哨兵
        min.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        deque.push(x);
        min.push(min.peek() > x ? x : min.peek());
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
}
