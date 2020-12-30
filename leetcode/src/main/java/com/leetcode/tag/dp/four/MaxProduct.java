package com.leetcode.tag.dp.four;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[][] dp = new int[nums.length][2];
            dp[0][0] = nums[0] > 0 ? 1 : nums[0];
            dp[0][1] = nums[0] > 0 ? nums[0] : 1;

            int max = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                dp[i][0] = Integer.MIN_VALUE;
                dp[i][1] = Integer.MIN_VALUE;
                if (nums[i] < 0) {
                    dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                    dp[i][1] = dp[i - 1][0] * nums[i];
                } else if (nums[i] > 0) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                }
                max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
            }

            return max;
        }
    }
}
