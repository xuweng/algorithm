package com.leetcode.tag.daily.seven;

/**
 * 643. 子数组最大平均数 I
 */
public class FindMaxAverage {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double sum = 0;
            double result = Double.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += i >= k ? nums[i] - nums[i - k] : nums[i];

                if (i >= k - 1) {
                    result = Math.max(result, sum / k);
                }
            }

            return result;
        }
    }
}
