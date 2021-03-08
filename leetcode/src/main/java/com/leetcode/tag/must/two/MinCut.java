package com.leetcode.tag.must.two;

/**
 * 132. 分割回文串 II
 */
public class MinCut {
    class Solution {
        public int minCut(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int[] dp = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i] = Integer.MAX_VALUE;
                if (is(s, 0, i)) {
                    dp[i] = 0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (is(s, j, i)) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[s.length() - 1];
        }

        private boolean is(String s, int i, int j) {
            for (int k = i; k <= j; k++) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }

            return true;
        }
    }
}
