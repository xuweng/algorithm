package com.leetcode.tag.slidingwindow;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen1 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            while (left <= right) {
                sum += nums[right];
                while (sum >= target) {
                    min = Math.max(min, right - left + 1);
                    sum -= nums[left++];
                }
            }

            return min;
        }
    }
}
