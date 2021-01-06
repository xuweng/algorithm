package com.leetcode.tag.dp.six;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int[] result = new int[nums.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                if (i + 1 >= k) {
                    result[i + 1 - k] = nums[deque.peekFirst()];
                }
            }

            return result;
        }
    }
}
