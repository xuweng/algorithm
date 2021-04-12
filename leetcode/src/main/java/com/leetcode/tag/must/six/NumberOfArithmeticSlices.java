package com.leetcode.tag.must.six;

/**
 * 413. 等差数列划分
 */
public class NumberOfArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
            }

            return dp[dp.length - 1];
        }
    }
}
