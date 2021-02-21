package com.leetcode.tag.daily.eight;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 */
public class LongestSubarray {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            int right = 0;
            int result = 0;

            while (right < nums.length) {
                int min = getMin(nums, left, right);
                while (min > limit) {
                    left++;

                    min = getMin(nums, left, right);
                }
                result = Math.max(result, right - left + 1);
                right++;
            }

            return result;
        }

        private int getMin(int[] nums, int left, int right) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }

            return max - min;
        }
    }
}
