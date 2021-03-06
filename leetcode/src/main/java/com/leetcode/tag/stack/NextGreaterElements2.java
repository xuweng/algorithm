package com.leetcode.tag.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 */
public class NextGreaterElements2 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            if (nums == null || nums.length == 0) {
                return nums;
            }
            int[] result = new int[nums.length];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 2 * nums.length - 1; i >= 0; i--) {
                int index = i % nums.length;
                while (!deque.isEmpty() && nums[deque.peek()] <= nums[index]) {
                    deque.pop();
                }
                result[index] = deque.isEmpty() ? -1 : nums[deque.peek()];
                deque.push(index);
            }

            return result;
        }
    }
}
