package com.leetcode.tag.must2.seven;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 */
public class MaxQueue {
    Deque<Integer> deque;
    Deque<Integer> stack;

    public MaxQueue() {
        deque = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public int max_value() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }

    public void push_back(int value) {
        deque.offerLast(value);

        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            stack.push(stack.peek() > value ? stack.peek() : value);
        }
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.pollFirst();
    }
}
