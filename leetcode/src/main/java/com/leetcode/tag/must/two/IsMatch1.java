package com.leetcode.tag.must.two;

/**
 * 44. 通配符匹配
 */
public class IsMatch1 {
    /**
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。*不能全部配匹.
     */
    class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            // 空初始化
            dp[0][0] = true;
            // 配匹空
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '*') {
                    // 连续*配匹空
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) == '*') {
                        // 不考虑*前
                        // 不使用*
                        // 使用*
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }

            return dp[s.length()][p.length()];
        }
    }
}
