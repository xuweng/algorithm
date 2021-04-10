package com.leetcode.tag.must.four;

/**
 * 264. 丑数 II
 */
public class NthUglyNumber {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                // v2,v3,v5三者可能相等 这3个只要=dp[i]都要移动
                int v2 = dp[p2] * 2, v3 = dp[p3] * 3, v5 = dp[p5] * 5;
                dp[i] = Math.min(v2, Math.min(v3, v5));
                if (dp[i] == v2) {
                    p2++;
                } else if (dp[i] == v3) {
                    p3++;
                } else {
                    p5++;
                }
            }

            return dp[n];
        }
    }

    class Solution1 {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                int v2 = dp[p2] * 2, v3 = dp[p3] * 3, v5 = dp[p5] * 5;
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
