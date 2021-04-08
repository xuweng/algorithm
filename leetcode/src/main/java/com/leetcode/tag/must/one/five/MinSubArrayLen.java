package com.leetcode.tag.must.one.five;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = 0;
            int sum = 0;
            int result = Integer.MAX_VALUE;
            while (right < nums.length) {
                sum += nums[right];
                while (sum >= target) {
                    result = Math.min(result, right - left + 1);
                    sum = sum - nums[left++];
                }
                right++;
            }

            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }
}
