package com.leetcode.tag.must.one.three;

/**
 * 44. 通配符匹配
 * <p>
 * 初始化
 */
public class IsMatch {
    class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            // 空配匹空
            dp[0][0] = true;
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '*') {
                    // 只有*配匹空
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }

            return dp[s.length()][p.length()];
        }
    }
}
