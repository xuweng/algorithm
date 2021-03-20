package com.leetcode.tag.dp.one.three;

/**
 * 673. 最长递增子序列的个数
 */
public class FindNumberOfLIS {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int[] count = new int[nums.length];

            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                count[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= nums[i]) {
                        continue;
                    }
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = dp[j];
                    } else {
                        count[i] += count[j];
                    }
                }
                max = Math.max(max, dp[i]);
            }

            int result = 0;
            for (int j : count) {
                if (j == max) {
                    result++;
                }
            }
            return result;
        }
    }
}
