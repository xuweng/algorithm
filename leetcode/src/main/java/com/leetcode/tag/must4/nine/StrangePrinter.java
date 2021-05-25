package com.leetcode.tag.must4.nine;

/**
 * 664. 奇怪的打印机
 */
public class StrangePrinter {
    class Solution {
        public int strangePrinter(String s) {
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }

            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        int max = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            max = Math.min(max, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = max;
                    }
                }
            }

            return dp[0][s.length() - 1];
        }
    }
}
