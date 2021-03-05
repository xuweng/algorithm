package com.leetcode.tag.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 */
public class MyQueue {
    Deque<Integer> stack;
    Deque<Integer> stack1;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new LinkedList<>();
        stack1 = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        }
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }

        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack1.isEmpty()) {
            return stack1.peek();
        }
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }

        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty() && stack1.isEmpty();
    }
}
