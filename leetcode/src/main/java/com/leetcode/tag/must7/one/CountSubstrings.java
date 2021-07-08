package com.leetcode.tag.must7.one;

/**
 * 647. 回文子串
 */
public class CountSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            int count = s.length();
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if (j > i + 1) {
                        dp[i][j] = dp[i][j] && dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
