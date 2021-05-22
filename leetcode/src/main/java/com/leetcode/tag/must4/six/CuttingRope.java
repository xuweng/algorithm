package com.leetcode.tag.must4.six;

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * i j 模型
 */
public class CuttingRope {
    class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                for (int j = 2; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }

            return dp[n];
        }
    }

    class Solution1 {
        public int cuttingRope(int n) {
            if (n < 4) {
                return n - 1;
            }
            int result = 1;
            while (n > 4) {
                result *= 3;
                n -= 3;
            }

            return result * n;
        }
    }
}
