package com.leetcode.tag.dp.seven;

/**
 * 516. 最长回文子序列
 */
public class LongestPalindromeSubseq1 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = i;
            }
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[0][s.length() - 1];
        }
    }
}
