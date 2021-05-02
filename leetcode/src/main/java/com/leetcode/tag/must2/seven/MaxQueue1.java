package com.leetcode.tag.must2.seven;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * <p>
 * 方法二：维护一个单调的双端队列
 */
public class MaxQueue1 {
    class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> max;

        public MaxQueue() {
            queue = new LinkedList<>();
            max = new LinkedList<>();
        }

        public int max_value() {
            if (max.isEmpty()) {
                return -1;
            }
            // 单调递减队列 第一个最大
            return max.peekFirst();
        }

        /**
         * 单调递减队列
         *
         * @param value
         */
        public void push_back(int value) {
            while (!max.isEmpty() && max.peekLast() < value) {
                max.pollLast();
            }
            max.offerLast(value);
            queue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int ans = queue.poll();
            if (ans == max.peekFirst()) {
                max.pollFirst();
            }
            return ans;
        }
    }
}
