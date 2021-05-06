package com.leetcode.tag.must3;

/**
 * 剑指 Offer 60. n个骰子的点数
 * <p>
 * 求和 求和 求和 求和 求和
 */
public class DicesProbability {
    class Solution {
        public double[] dicesProbability(int n) {
            int[][] dp = new int[n + 1][6 * n + 1];
            // 第一个有1到6
            for (int j = 1; j <= 6; j++) {
                dp[1][j] = 1;
            }

            for (int i = 2; i <= n; i++) {
                // i个1，i个6
                for (int j = i; j <= 6 * i; j++) {
                    // i<=j, i-1<=j-k
                    for (int k = 1; k <= 6 && i - 1 <= j - k; k++) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }

            // P(k) = k出现的次数 / 总次数
            // 投掷 n 个骰子，所有点数出现的总次数是 6^n ，因为一共有 n 枚骰子，每枚骰子的点数都有 6 种可能出现的情况。
            double[] ans = new double[6 * n - n + 1];
            // 投掷 n 个骰子 n<=k出现的次数<=6*n
            // n个1，n个6
            for (int i = n; i <= 6 * n; i++) {
                ans[i - n] = ((double) dp[n][i]) / (Math.pow(6, n));
            }
            return ans;
        }
    }
}
