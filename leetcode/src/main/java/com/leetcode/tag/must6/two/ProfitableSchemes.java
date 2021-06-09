package com.leetcode.tag.must6.two;

/**
 * 879. 盈利计划
 */
public class ProfitableSchemes {
    class Solution {
        int mod = (int) (1e9 + 7);

        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            int[][] dp = new int[n + 1][minProfit + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1;
            }
            int len = group.length;
            for (int i = 1; i <= len; i++) {
                int g = group[i - 1];
                int p = profit[i - 1];
                // 枚举员工 倒序
                for (int j = n; j >= g; j--) {
                    // 枚举利润 倒序 至少 至少
                    for (int k = minProfit; k >= 0; k--) {
                        dp[j][k] += dp[j - g][Math.max(0, k - p)];
                        dp[j][k] %= mod;
                    }
                }
            }

            return dp[n][minProfit];
        }
    }
}
