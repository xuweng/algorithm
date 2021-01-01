package com.leetcode.tag.dp.four;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct1 {
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[][] dp = new int[nums.length][2];
            dp[0][0] = nums[0] > 0 ? 1 : nums[0];
            dp[0][1] = nums[0] > 0 ? nums[0] : 1;

            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 初始化为1
                dp[i][0] = 1;
                dp[i][1] = 1;
                if (nums[i] < 0) {
                    dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] * nums[i]);
                } else if (nums[i] > 0) {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] * nums[i]);
                    dp[i][1] = dp[i - 1][1] * nums[i];
                } else {
                    dp[i][0] = dp[i][1] = 0;
                }

                max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
            }

            return max;
        }
    }
}
