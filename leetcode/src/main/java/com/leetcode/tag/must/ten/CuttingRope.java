package com.leetcode.tag.must.ten;

import java.math.BigInteger;
import java.util.Arrays;

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

            return dp[n] % 1000000007;
        }
    }

    /**
     * 贪心
     * <p>
     * 核心思路是：尽可能把绳子分成长度为3的小段，这样乘积最大
     */
    class Solution1 {
        public int cuttingRope(int n) {
            if (n < 4) {
                return n - 1;
            }
            long res = 1;
            while (n > 4) {
                res = res * 3 % 1000000007;
                n -= 3;
            }
            return (int) (res * n % 1000000007);
        }
    }

    /**
     * 动态规划：大数取余
     */
    class Solution2 {
        public int cuttingRope(int n) {
            BigInteger[] dp = new BigInteger[n + 1];
            Arrays.fill(dp, BigInteger.valueOf(1));
            // dp[1] = BigInteger.valueOf(1);
            for (int i = 3; i < n + 1; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
                }
            }
            return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
        }
    }
}
