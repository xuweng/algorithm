package com.leetcode.tag.must5.three;

/**
 * 91. 解码方法
 */
public class NumDecodings {
    class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;

            for (int i = 1; i <= s.length(); i++) {
                if (s.charAt(i - 1) != '0') {
                    dp[i] = dp[i - 1];
                }
                if (i >= 2 && (s.charAt(i - 2) != '0') && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

            return dp[s.length()];
        }
    }

    class Solution1 {
        public int numDecodings(String s) {
            int a = 0;
            int b = 1;
            int c = 0;

            for (int i = 1; i <= s.length(); i++) {
                c = 0;
                if (s.charAt(i - 1) != '0') {
                    c = b;
                }
                if (i >= 2 && (s.charAt(i - 2) != '0') && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
                    c += a;
                }
                a = b;
                b = c;
            }

            return c;
        }
    }
}
