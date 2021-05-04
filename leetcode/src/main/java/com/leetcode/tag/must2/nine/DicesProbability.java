package com.leetcode.tag.must2.nine;

/**
 * 剑指 Offer 60. n个骰子的点数
 * <p>
 * 新 不是
 * <p>
 * 正负 正负 正负
 */
public class DicesProbability {
    class Solution {
        public double[] dicesProbability(int n) {
            int[][] dp = new int[n + 1][6 * n + 1];
            // 投掷完 第1 枚骰子后，它的可能点数分别为 1, 2, 3, ... , 6，并且每个点数出现的次数都是 1
            for (int i = 1; i <= 6; i++) {
                dp[1][i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= 6 * i; j++) {
                    for (int k = 1; k <= 6 && i - 1 <= j - k; k++) {
                        // i<=j
                        // i - 1<=j-k
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }

            // P(k) = k出现的次数 / 总次数
            // 投掷 n 个骰子，所有点数出现的总次数是 6^n ，因为一共有 n 枚骰子，每枚骰子的点数都有 6 种可能出现的情况。
            double[] ans = new double[6 * n - n + 1];
            for (int i = n; i <= 6 * n; i++) {
                ans[i - n] = ((double) dp[n][i]) / (Math.pow(6, n));
            }
            return ans;
        }
    }
}
