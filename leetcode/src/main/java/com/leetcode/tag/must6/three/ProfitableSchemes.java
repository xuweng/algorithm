package com.leetcode.tag.must6.three;

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
            for (int i = 0; i < group.length; i++) {
                int g = group[i];
                int p = profit[i];
                // 枚举员工
                for (int j = n; j >= g; j--) {
                    // 枚举利润
                    for (int k = minProfit; k >= 0; k--) {
                        // 至少k
                        dp[j][k] += dp[j - g][Math.max(0, k - p)];
                    }
                }
            }

            return dp[n][minProfit];
        }
    }
}
