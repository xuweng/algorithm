package com.leetcode.tag.must1.three;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 */
public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            if (T == null) {
                return null;
            }
            int[] result = new int[T.length];
            Deque<Integer> deque = new LinkedList<>();
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
