package com.leetcode.tag.dp.three;

/**
 * 673. 最长递增子序列的个数
 */
public class FindNumberOfLIS1 {
    static class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int[] c = new int[nums.length];
            dp[0] = 1;
            c[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= nums[i]) {
                        continue;
                    }
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        c[i] = c[j];
                    } else {
                        c[i] += c[j];
                    }
                }
            }
            int max = 0;
            for (int num : dp) {
                max = Math.max(max, num);
            }
            int result = 0;
            for (int i : c) {
                if (i == max) {
                    result++;
                }
            }
            return result;
        }
    }
}
