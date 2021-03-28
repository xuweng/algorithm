package com.leetcode.tag.must.three;

/**
 * 115. 不同的子序列
 */
public class NumDistinct {
    class Solution {
        public int numDistinct(String s, String t) {
            if (s == null || t == null) {
                return 0;
            }
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                }
            }

            return dp[s.length()][t.length()];
        }
    }

    class Solution1 {
        public int numDistinct(String s, String t) {
            if (s == null || t == null) {
                return 0;
            }
            int[] dp = new int[t.length() + 1];
            // 初始化 初始化溢出
            dp[0] = 1;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[j] += dp[j - 1];
                    }
                }
            }

            return dp[t.length()];
        }
    }
}
