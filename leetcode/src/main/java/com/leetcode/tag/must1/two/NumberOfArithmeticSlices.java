package com.leetcode.tag.must1.two;

/**
 * 413. 等差数列划分
 */
public class NumberOfArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 结尾 长度 下标
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
