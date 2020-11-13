package com.leetcode.tag.binarysearch.one;

/**
 * 174. 地下城游戏
 */
public class CalculateMinimumHP2 {
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null || dungeon.length == 0) {
                return 0;
            }
            int row = dungeon.length - 1;
            int col = dungeon[0].length - 1;
            int[][] dp = new int[dungeon.length][dungeon[0].length];
            // 终点
            dp[row][col] = Math.max(0, -dungeon[row][col]);

            //最后一行
            for (int i = col - 1; i >= 0; i--) {
                int v = dp[row][i + 1] - dungeon[row][i];
                dp[row][i] = Math.max(v, 0);
            }

            // 最后一列
            for (int i = row - 1; i >= 0; i--) {
                int v = dp[i + 1][col] - dungeon[i][col];
                dp[i][col] = Math.max(v, 0);
            }

            // 倒数第二行开始
            for (int i = row - 1; i >= 0; i--) {
                // 倒数第二列开始
                for (int j = col - 1; j >= 0; j--) {
                    int v = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                    dp[i][j] = Math.max(v, 0);
                }
            }

            // 注意+1
            return dp[0][0] + 1;
        }
    }
}
