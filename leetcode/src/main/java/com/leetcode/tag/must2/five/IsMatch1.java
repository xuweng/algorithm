package com.leetcode.tag.must2.five;

/**
 * 10. 正则表达式匹配
 */
public class IsMatch1 {
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2];
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        }
                    } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }

            return dp[s.length()][p.length()];
        }
    }
}
