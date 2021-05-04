package com.leetcode.tag.must2.nine;

/**
 * 1473. 粉刷房子 III
 */
public class MinCost {
    class Solution {
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            int[][][] dp = new int[m + 1][n + 1][target + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[i][j][0] = Integer.MAX_VALUE / 2;
                }
            }
            // 枚举房子
            for (int i = 1; i <= m; i++) {
                // 枚举颜色
                for (int j = 1; j <= n; j++) {
                    // 枚举街区
                    for (int k = 1; k <= target; k++) {
                        // 形成分区数量大于房子数量，状态无效 必须
                        if (k > i) {
                            dp[i][j][k] = Integer.MAX_VALUE / 2;
                            continue;
                        }
                        // 房子没有上色
                        if (houses[i - 1] == 0) {
                            // 新街区
                            int temp = Integer.MAX_VALUE / 2;
                            for (int i1 = 1; i1 <= n; i1++) {
                                if (i1 != j) {
                                    temp = Math.min(temp, dp[i - 1][i1][k - 1]);
                                }
                            }
                            dp[i][j][k] = Math.min(dp[i - 1][j][k], temp) + cost[i - 1][j - 1];
                        } else {
                            // 房子已经上色
                            if (j == houses[i - 1]) {
                                int temp = Integer.MAX_VALUE / 2;
                                for (int i1 = 1; i1 <= n; i1++) {
                                    if (i1 != j) {
                                        temp = Math.min(temp, dp[i - 1][i1][k - 1]);
                                    }
                                }
                                dp[i][j][k] = Math.min(dp[i - 1][j][k], temp);
                            } else {
                                dp[i][j][k] = Integer.MAX_VALUE / 2;
                            }
                        }
                    }
                }
            }

            int result = Integer.MAX_VALUE / 2;
            for (int i = 1; i <= n; i++) {
                result = Math.min(result, dp[m][i][target]);
            }

            return result == Integer.MAX_VALUE / 2 ? -1 : result;
        }
    }
}
