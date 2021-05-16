package com.leetcode.tag.must3.ten;

/**
 * 1043. 分隔数组以得到最大和
 */
public class MaxSumAfterPartitioning {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            // 长度 长度
            int[] dp = new int[arr.length + 1];
            // 长度
            for (int i = 1; i <= arr.length; i++) {
                int max = 0;
                // 索引
                // 长度j 下标j
                for (int j = i - 1; j >= 0 && (i - j) <= k; j--) {
                    max = Math.max(max, arr[j]);
                    // 前j个 最后一个
                    // 最后一个 [j,i-1]
                    dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                }
            }

            return dp[arr.length];
        }
    }
}
