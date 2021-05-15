package com.leetcode.tag.must3.nine;

/**
 * 1043. 分隔数组以得到最大和
 */
public class MaxSumAfterPartitioning {
    class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int n = A.length;
            // dp[i]：数组的前i个数即nums[0,1...i-1],被切了Y-刀，分割成Y个数组
            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int max = dp[i];
                for (int j = i - 1; j >= 0 && (i - j) <= K; j--) {
                    max = Math.max(max, A[j]);
                    dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                }
            }
            return dp[n];
        }
    }
}
