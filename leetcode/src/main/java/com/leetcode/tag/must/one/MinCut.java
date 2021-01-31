package com.leetcode.tag.must.one;

/**
 * 132. 分割回文串 II
 */
public class MinCut {
    class Solution {
        public int minCut(String s) {
            if (s == null || s.length() <= 1) {
                return 0;
            }
            int[] dp = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i] = i;
            }
            for (int i = 1; i < s.length(); i++) {
                // [0,i]是回文串 不用切割
                if (isHui(s, 0, i)) {
                    dp[i] = 0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (isHui(s, j + 1, i)) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[s.length() - 1];
        }

        private boolean isHui(String s, int i, int j) {
            while (i < j) {
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
