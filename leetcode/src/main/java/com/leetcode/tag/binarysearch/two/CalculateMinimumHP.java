package com.leetcode.tag.binarysearch.two;

/**
 * 174. 地下城游戏
 */
public class CalculateMinimumHP {
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null || dungeon.length == 0) {
                return 0;
            }
            int row = dungeon.length - 1;
            int col = dungeon[0].length - 1;
            int[][] dp = new int[dungeon.length][dungeon[0].length];
            dp[row][col] = Math.max(0, -dungeon[row][col]);

            //最后一行
            for (int i = col; i >= 0; i--) {
                int d = dp[row][i + 1] - dungeon[row][i];
                dp[row][i] = Math.max(0, d);
            }
            //最后一列
            for (int i = row; i >= 0; i--) {
                int d = dp[i + 1][col] - dungeon[i][col];
                dp[row][i] = Math.max(0, d);
            }

            for (int i = row - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    int d = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                    dp[i][j] = Math.max(0, d);
                }
            }

            return dp[0][0] + 1;
        }
    }
}
