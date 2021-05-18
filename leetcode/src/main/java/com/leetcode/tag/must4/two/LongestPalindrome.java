package com.leetcode.tag.must4.two;

/**
 * 5. 最长回文子串
 * <p>
 * 预处理 候选集
 * <p>
 * 行 列 3*3 索引
 * <p>
 * 重置 覆盖
 */
public class LongestPalindrome {
    class Solution {
        public String longestPalindrome(String s) {
            int[][] dp = new int[s.length()][s.length()];
            int left = 0;
            int right = 0;

            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                    if (dp[i][j] > right - left + 1) {
                        left = i;
                        right = j;
                    }
                }
            }

            return s.substring(left, right + 1);
        }
    }
}
