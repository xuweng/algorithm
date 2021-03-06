package com.leetcode.tag.must4.six;

/**
 * 剑指 Offer 49. 丑数
 * <p>
 * 一一分配 一一分配 一一分配
 */
public class NthUglyNumber {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                int v2 = 2 * dp[p2], v3 = 3 * dp[p3], v5 = 5 * dp[p5];
                dp[i] = Math.min(v2, Math.min(v3, v5));
                if (dp[i] == v2) {
                    p2++;
                }
                if (dp[i] == v3) {
                    p3++;
                }
                if (dp[i] == v5) {
                    p5++;
                }
            }

            return dp[n];
        }
    }
}
