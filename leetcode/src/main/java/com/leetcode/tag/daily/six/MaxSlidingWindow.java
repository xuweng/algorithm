package com.leetcode.tag.daily.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <= nums.length - k; i++) {
                result.add(max(nums, i, i + k));
            }

            return result.stream().mapToInt(integer -> integer).toArray();
        }

        private int max(int[] nums, int start, int end) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i < end; i++) {
                max = Math.max(max, nums[i]);
            }

            return max;
        }
    }
}
