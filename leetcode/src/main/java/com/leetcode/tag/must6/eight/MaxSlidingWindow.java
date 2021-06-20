package com.leetcode.tag.must6.eight;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 */
public class MaxSlidingWindow {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];

            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                if (i - deque.peekFirst() >= k) {
                    deque.pollFirst();
                }
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return result;
        }
    }
}
