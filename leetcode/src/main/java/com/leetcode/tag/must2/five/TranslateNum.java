package com.leetcode.tag.must2.five;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 */
public class TranslateNum {
    class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;

            for (int i = 1; i <= s.length(); i++) {
                dp[i] = dp[i - 1];
                if (i >= 2 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 25)) {
                    dp[i] += dp[i - 2];
                }
            }

            return dp[s.length()];
        }
    }
}
