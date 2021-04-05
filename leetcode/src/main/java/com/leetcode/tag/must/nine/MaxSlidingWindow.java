package com.leetcode.tag.must.nine;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null) {
                return nums;
            }
            int[] result = new int[nums.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (i - deque.peekFirst() >= k) {
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
