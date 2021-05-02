package com.leetcode.tag.must2.seven;

import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 */
public class DicesProbability {
    class Solution {
        public double[] dicesProbability(int n) {
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0 / 6.0);
            for (int i = 2; i <= n; i++) {
                double[] tmp = new double[5 * i + 1];
                for (int j = 0; j < dp.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        tmp[j + k] += dp[j] / 6.0;
                    }
                }
                dp = tmp;
            }
            return dp;
        }
    }

    class Solution1 {
        public double[] dicesProbability(int n) {
            // dp[i][j] ，表示投掷完 i 枚骰子后，点数 j 的出现次数
            int[][] dp = new int[n + 1][6 * n + 1];
            // 投掷完 第1 枚骰子后，它的可能点数分别为 1, 2, 3, ... , 6，并且每个点数出现的次数都是 1
            for (int i = 1; i <= 6; i++) {
                dp[1][i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= 6 * i; j++) {
                    for (int k = 1; k <= 6 && k <= j; k++) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }

            double[] ans = new double[6 * n - n + 1];
            for (int i = n; i <= 6 * n; i++) {
                ans[i - n] = ((double) dp[n][i]) / (Math.pow(6, n));
            }
            return ans;
        }
    }
}
