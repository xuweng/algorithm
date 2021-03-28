package com.leetcode.tag.must.three;

/**
 * 673. 最长递增子序列的个数
 * <p>
 * 初始化 初始化溢出
 */
public class FindNumberOfLIS {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int[] c = new int[nums.length];

            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                c[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= nums[i]) {
                        continue;
                    }
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        c[i] = c[j];
                    } else if (dp[i] == dp[j + 1]) {
                        c[i] += c[j];
                    }
                }

                max = Math.max(max, dp[i]);
            }
            int result = 0;
            for (int i = 0; i < dp.length; i++) {
                if (max == dp[i]) {
                    result += c[i];
                }
            }

            return result;
        }
    }
}
