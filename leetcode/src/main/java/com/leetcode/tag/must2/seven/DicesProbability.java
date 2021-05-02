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
            // 最大点是6，最多点数 6*n
            int[][] dp = new int[n + 1][6 * n + 1];
            // 投掷完 第1 枚骰子后，它的可能点数分别为 1, 2, 3, ... , 6，并且每个点数出现的次数都是 1
            for (int i = 1; i <= 6; i++) {
                dp[1][i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                // j 表示投掷完 i 枚骰子后的点数和
                // j 最小是 i, 每次都是1, i次
                // j 最大是  i*6，每次都是6，i次
                for (int j = i; j <= 6 * i; j++) {
                    // 第i次是 1, 2, 3, ... , 6
                    for (int k = 1; k <= 6 && k <= j; k++) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }

            // 点数 k 出现概率就算公式为：
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
