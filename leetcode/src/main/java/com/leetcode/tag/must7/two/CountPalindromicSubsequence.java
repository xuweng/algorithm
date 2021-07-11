package com.leetcode.tag.must7.two;

/**
 * 5809. 长度为 3 的不同回文子序列
 */
public class CountPalindromicSubsequence {
    class Solution {
        public int countPalindromicSubsequence(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }
            int count = 0;
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                    if (dp[i][j] == 3) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
