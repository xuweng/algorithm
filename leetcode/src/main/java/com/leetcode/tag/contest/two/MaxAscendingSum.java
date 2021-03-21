package com.leetcode.tag.contest.two;

/**
 * 5709. 最大升序子数组和
 */
public class MaxAscendingSum {
    class Solution {
        public int maxAscendingSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int max = nums[0];
            int sum = max;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }

                max = Math.max(max, sum);
            }

            return max;
        }
    }
}
