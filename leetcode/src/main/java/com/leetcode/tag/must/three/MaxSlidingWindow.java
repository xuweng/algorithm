package com.leetcode.tag.must.three;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
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
                // 窗口外
                while (i - deque.peekFirst() >= k) {
                    deque.pollFirst();
                }
                // 够一个窗口
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return result;
        }
    }

    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return nums;
            }
            Deque<Integer> deque = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                // 窗口外
                while (i - deque.peekFirst() >= k) {
                    deque.pollFirst();
                }
                // 够一个窗口
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return result;
        }
    }
}
