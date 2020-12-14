package com.leetcode.tag.dp.three;

/**
 * 673. 最长递增子序列的个数
 * <p>
 * 搞懂题目 搞懂题目 搞懂题目 搞懂题目 搞懂题目 搞懂题目
 * <p>
 * 搞懂题目 搞懂题目 搞懂题目 搞懂题目 搞懂题目 搞懂美团
 * <p>
 * 路径个数 路径个数 路径个数 路径个数 路径个数 路径个数
 * <p>
 * 回溯 回溯 回溯 回溯 回溯 路径个数 路径个数 路径个数
 */
public class FindNumberOfLIS {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            int result = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (dp[j] < dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                // 错误
                if (dp[i] == max) {
                    result++;
                } else if (dp[i] > max) {
                    result = 1;
                    max = dp[i];
                }
            }

            return result;

        }
    }
}
