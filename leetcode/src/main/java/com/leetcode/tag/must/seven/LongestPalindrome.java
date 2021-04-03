package com.leetcode.tag.must.seven;

/**
 * 5. 最长回文子串
 */
public class LongestPalindrome {
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null) {
                return null;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            int left = 0;
            int right = 0;
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if (j > i + 1) {
                        dp[i][j] = dp[i][j] && dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && (j - i > right - left)) {
                        left = i;
                        right = j;
                    }
                }
            }

            return s.substring(left, right + 1);
        }
    }
}
