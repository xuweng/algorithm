package com.leetcode.tag.must2.five;

/**
 * 413. 等差数列划分
 */
public class NumberOfArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int[] dp = new int[nums.length];
            int sum = 0;
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
                sum += dp[i];
            }

            return sum;
        }
    }
}
