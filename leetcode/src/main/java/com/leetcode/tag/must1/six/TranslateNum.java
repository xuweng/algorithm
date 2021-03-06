package com.leetcode.tag.must1.six;

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

    class Solution1 {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int a = 0;
            int b = 1;
            int cur = 0;

            for (int i = 1; i <= s.length(); i++) {
                cur = b;
                if (i >= 2 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 25)) {
                    cur += a;
                }
                a = b;
                b = cur;
            }

            return cur;
        }
    }
}
