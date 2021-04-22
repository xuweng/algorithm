package com.leetcode.tag.must1.five;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 */
public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            Deque<Integer> deque = new LinkedList<>();
            int[] result = new int[T.length];

            for (int i = T.length - 1; i >= 0; i--) {
                while (!deque.isEmpty() && T[deque.peekLast()] <= T[i]) {
                    deque.pollLast();
                }
                result[i] = deque.isEmpty() ? 0 : deque.peekLast() - i;
                deque.offerLast(i);
            }

            return result;
        }
    }
}
