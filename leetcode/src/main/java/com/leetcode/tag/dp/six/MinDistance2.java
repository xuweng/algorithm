package com.leetcode.tag.dp.six;

/**
 * 72. 编辑距离
 */
public class MinDistance2 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int row = word1.length();
            int col = word2.length();
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i <= row; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= col; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j < col; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    }
                }
            }

            return dp[row][col];
        }
    }
}
