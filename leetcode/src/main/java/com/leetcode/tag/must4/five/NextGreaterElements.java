package com.leetcode.tag.must4.five;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 * <p>
 * 修改前记录 修改前记录 修改前记录
 * <p>
 * i j 模型
 * <p>
 * i j 模型
 * <p>
 * i j 模型
 */
public class NextGreaterElements {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> deque = new LinkedList<>();
            int[] result = new int[nums.length];
            for (int i = 2 * nums.length - 1; i >= 0; i--) {
                int index = i % nums.length;
                while (!deque.isEmpty() && deque.peekLast() <= nums[index]) {
                    deque.pollLast();
                }
                result[index] = deque.isEmpty() ? -1 : deque.peekFirst();
                deque.offerLast(nums[index]);
            }

            return result;
        }
    }
}
