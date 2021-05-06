package com.leetcode.tag.must3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 */
public class MaxQueue {
    Deque<Integer> deque;
    Deque<Integer> max;

    public MaxQueue() {
        deque = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) {
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        deque.offerLast(value);
        // 单调递减队列 max.peekLast() = value?
        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.offerLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        Integer integer = deque.pollFirst();
        if (integer.equals(max.peekFirst())) {
            max.pollFirst();
        }
        return integer;
    }
}
