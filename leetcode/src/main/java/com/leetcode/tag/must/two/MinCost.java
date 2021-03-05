package com.leetcode.tag.must.two;

import java.util.Arrays;

/**
 * 1547. 切棍子的最小成本
 */
public class MinCost {
    class Solution {
        public int minCost(int n, int[] cuts) {
            if (cuts == null || cuts.length == 0) {
                return 0;
            }
            Arrays.sort(cuts);

            int[] nCuts = new int[cuts.length + 2];
            for (int i = 0; i < cuts.length; i++) {
                nCuts[i + 1] = cuts[i];
            }
            nCuts[cuts.length + 1] = n;

            int[][] dp = new int[nCuts.length][nCuts.length];
            // 枚举切点
            for (int i = nCuts.length - 2; i >= 1; i--) {
                for (int j = i; j <= nCuts.length - 2; j++) {
                    dp[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                    }
                    dp[i][j] += nCuts[j + 1] - nCuts[i - 1];
                }
            }

            return dp[1][nCuts.length - 2];
        }
    }
}
