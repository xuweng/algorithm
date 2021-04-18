package com.leetcode.tag.must1.two;

/**
 * 132. 分割回文串 II
 */
public class MinCut {
    class Solution {
        public int minCut(String s) {
            if (s == null) {
                return 0;
            }
            boolean[][] is = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                is[i][i] = true;
            }
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    is[i][j] = s.charAt(i) == s.charAt(j);
                    if (j > i + 1) {
                        is[i][j] = is[i][j] && is[i + 1][j - 1];
                    }
                }
            }
            int[] dp = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i] = s.length();
                if (is[0][i]) {
                    dp[i] = 0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (is[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[dp.length - 1];
        }
    }
}
