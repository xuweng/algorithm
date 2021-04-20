package com.leetcode.tag.must1.three;

/**
 * 1004. 最大连续1的个数 III
 */
public class LongestOnes {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            if (nums == null) {
                return 0;
            }
            int left = 0;
            int right = 0;
            int sum = 0;
            int max = 0;
            while (right < nums.length) {
                sum += nums[right];
                while (right - left + 1 > sum + k) {
                    sum -= nums[left++];
                }
                max = Math.max(max, right - left + 1);
                right++;
            }

            return max;
        }
    }
}
