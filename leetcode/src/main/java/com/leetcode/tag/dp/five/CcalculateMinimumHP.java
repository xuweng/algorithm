package com.leetcode.tag.dp.five;

/**
 * 174. 地下城游戏
 */
public class CcalculateMinimumHP {
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null || dungeon.length == 0) {
                return 0;
            }
            int row = dungeon.length - 1;
            int col = dungeon[0].length - 1;
            int[][] dp = new int[row + 1][col + 1];

            dp[row][col] = Math.max(0, -dungeon[row][col]);
            // 最后一行
            for (int i = col - 1; i >= 0; i--) {
                int m = dungeon[row][i] - dp[row][i + 1];
                dp[row][i] = Math.max(0, -m);
            }
            // 最后一列
            for (int i = row - 1; i >= 0; i--) {
                int m = dungeon[i][col] - dp[i + 1][col];
                dp[i][col] = Math.max(0, -m);
            }
            for (int i = row - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                    int m = dungeon[i][j] - min;
                    dp[i][j] = Math.max(0, -m);
                }
            }

            return dp[0][0];
        }
    }
}
