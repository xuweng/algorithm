package com.leetcode.tag.must2.seven;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

        return stack.peekLast();
    }

    public void push_back(int value) {
        deque.offerLast(value);

        if (stack.isEmpty()) {
            stack.offerLast(value);
        } else {
            stack.offerLast(stack.peekLast() > value ? stack.peekLast() : value);
        }
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        stack.pollFirst();
        return deque.pollFirst();
    }

    /**
     * 方法一：暴力
     */
    class MaxQueue1 {
        int[] q = new int[20000];
        int begin = 0, end = 0;

        public MaxQueue1() {

        }

        public int max_value() {
            int ans = -1;
            for (int i = begin; i != end; ++i) {
                ans = Math.max(ans, q[i]);
            }
            return ans;
        }

        public void push_back(int value) {
            q[end++] = value;
        }

        public int pop_front() {
            if (begin == end) {
                return -1;
            }
            return q[begin++];
        }
    }

    /**
     * 方法二：维护一个单调的双端队列
     */
    class MaxQueue2 {
        Queue<Integer> q;
        Deque<Integer> d;

        public MaxQueue2() {
            q = new LinkedList<>();
            d = new LinkedList<>();
        }

        public int max_value() {
            if (d.isEmpty()) {
                return -1;
            }
            return d.peekFirst();
        }

        public void push_back(int value) {
            while (!d.isEmpty() && d.peekLast() < value) {
                d.pollLast();
            }
            d.offerLast(value);
            q.offer(value);
        }

        public int pop_front() {
            if (q.isEmpty()) {
                return -1;
            }
            int ans = q.poll();
            if (ans == d.peekFirst()) {
                d.pollFirst();
            }
            return ans;
        }
    }
}
