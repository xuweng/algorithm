package com.leetcode.tag.must.one.two;

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
                // 求min需要初始化最大
                dp[i] = Integer.MAX_VALUE;
                if (is(s, 0, i)) {
                    dp[i] = 0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (is(s, j + 1, i)) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[s.length() - 1];
        }

        private boolean is(String s, int i, int j) {
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }
}
