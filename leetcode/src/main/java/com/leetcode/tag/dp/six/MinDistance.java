package com.leetcode.tag.dp.six;

/**
 * 72. 编辑距离
 */
public class MinDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int row = word1.length();
            int col = word2.length();
            int[][] dp = new int[row + 1][col + 1];

            // 第1行
            for (int i = 1; i <= col; i++) {
                dp[0][i] = i;
            }
            // 第1列
            for (int i = 1; i <= row; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }

            return dp[row][col];
        }
    }
}
