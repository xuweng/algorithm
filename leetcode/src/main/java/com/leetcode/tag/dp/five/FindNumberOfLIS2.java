package com.leetcode.tag.dp.five;

import java.util.Arrays;

/**
 * 673. 最长递增子序列的个数
 */
public class FindNumberOfLIS2 {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int[] c = new int[nums.length];
            Arrays.fill(dp, 1);
            Arrays.fill(c, 1);

            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= nums[i]) {
                        continue;
                    }
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        c[i] = c[j];
                    } else if (dp[i] == dp[j] + 1) {
                        c[i] += c[j];
                    }
                }

                max = Math.max(max, dp[i]);
            }

            int result = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == max) {
                    result += c[i];
                }
            }

            return result;
        }
    }
}
