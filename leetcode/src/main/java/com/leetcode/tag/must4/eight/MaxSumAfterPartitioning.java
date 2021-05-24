package com.leetcode.tag.must4.eight;

/**
 * 1043. 分隔数组以得到最大和
 */
public class MaxSumAfterPartitioning {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int[] dp = new int[arr.length + 1];
            for (int i = 1; i <= arr.length; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0 && (i - j <= k); j--) {
                    max = Math.max(max, arr[j]);
                    // [0,j-1] [j,i-1]
                    dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                }
            }

            return dp[arr.length];
        }
    }
}
