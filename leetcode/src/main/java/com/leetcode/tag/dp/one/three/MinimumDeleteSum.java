package com.leetcode.tag.dp.one.three;

import java.util.stream.IntStream;

/**
 * 712. 两个字符串的最小ASCII删除和
 */
public class MinimumDeleteSum {
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
                return 0;
            }
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }

            int sum1 = IntStream.range(0, s1.length()).map(s1::charAt).sum();
            int sum2 = IntStream.range(0, s2.length()).map(s2::charAt).sum();

            return sum1 + sum2 - 2 * dp[s1.length()][s2.length()];
        }
    }
}
