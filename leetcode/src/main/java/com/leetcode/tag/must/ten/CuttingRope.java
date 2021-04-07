package com.leetcode.tag.must.ten;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 */
public class CuttingRope {
    class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }

            return dp[n];
        }
    }
}
