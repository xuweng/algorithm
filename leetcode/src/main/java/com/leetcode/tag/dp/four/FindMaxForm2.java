package com.leetcode.tag.dp.four;

/**
 * 474. 一和零
 */
public class FindMaxForm2 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            if (strs == null || strs.length == 0) {
                return 0;
            }
            int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
            for (int i = 1; i <= strs.length; i++) {
                int[] c = count(strs[i - 1]);
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        if (j < c[0] || k < c[1]) {
                            dp[i][j][k] = dp[i - 1][j][k];
                        } else {
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - c[0]][k - c[1]] + 1);
                        }
                    }
                }
            }

            return dp[strs.length][m][n];
        }

        private int[] count(String s) {
            int[] result = new int[2];
            for (int i = 0; i < s.length(); i++) {
                result[s.charAt(i) - '0']++;
            }

            return result;
        }
    }
}
