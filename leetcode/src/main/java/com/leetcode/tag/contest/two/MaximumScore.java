package com.leetcode.tag.contest.two;

import java.util.PriorityQueue;

/**
 * 5704. 好子数组的最大分数
 */
public class MaximumScore {
    class Solution {
        public int maximumScore(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
                for (int j = i; j < nums.length; j++) {
                    priorityQueue.offer(nums[j]);

                    result = Math.max(result, priorityQueue.peek() * (j - i + 1));
                }
            }

            return result;
        }
    }
}
