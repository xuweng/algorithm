package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * 数据范围 数据范围 数据范围
 */
public class CuttingRope {
    class Solution {
        public int cuttingRope(int n) {
            // m、n都是整数，n>1并且m>1
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
            // 6 3*3
            // 7 3*3*1
            // 8 3*3*2
            // 9 3*3*3
            // 10 3*3*3*1
            int result = 1;
            while (n > 4) {
                result *= 3;
                n -= 3;
            }

            return result * n;
        }
    }
}
