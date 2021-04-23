package com.leetcode.tag.must1.six;

/**
 * 1004. 最大连续1的个数 III
 */
public class LongestOnes {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0;
            int right = 0;
            int sum = 0;
            int result = 0;

            while (right < nums.length) {
                sum += nums[right];
                while (right - left + 1 > sum + k) {
                    sum -= nums[left++];
                }
                result = Math.max(result, right - left + 1);
                right++;
            }

            return result;
        }
    }
}
