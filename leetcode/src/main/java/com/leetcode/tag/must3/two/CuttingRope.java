package com.leetcode.tag.must3.two;

/**
 * 剑指 Offer 14- I. 剪绳子
 */
public class CuttingRope {
    class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            // （m、n都是整数，n>1并且m>1）
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                for (int j = 2; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }

            return dp[n];
        }
    }
}
