package com.leetcode.tag.must.one.one;

/**
 * 32. 最长有效括号
 */
public class LongestValidParentheses {
    class Solution {
        /**
         * dp 下标越界判断
         *
         * @param s
         * @return
         */
        public int longestValidParentheses(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int[] dp = new int[s.length()];
            int max = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = ((i >= 2) ? dp[i - 2] : 0) + 2;
                    } else if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                    }

                    max = Math.max(max, dp[i]);
                }
            }

            return max;
        }
    }
}
