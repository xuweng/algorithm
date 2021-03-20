package com.leetcode.tag.dp.one.three;

/**
 * 583. 两个字符串的删除操作
 */
public class MinDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            if (word1 == null || word1.isEmpty() || word2 == null || word2.isEmpty()) {
                return 0;
            }
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }

            return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
        }
    }
}
