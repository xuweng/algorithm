package com.leetcode.tag.must1.two;

/**
 * 1824. 最少侧跳次数
 */
public class MinSideJumps {
    class Solution {
        public int minSideJumps(int[] obstacles) {
            if (obstacles == null) {
                return 0;
            }
            int[][] dp = new int[obstacles.length][4];
            // 2->1
            dp[0][1] = 1;
            // 2->3
            dp[0][3] = 1;
            for (int i = 1; i < obstacles.length; i++) {
                if (obstacles[i] == 1) {
                    dp[i][1] = Integer.MAX_VALUE - 1;
                    dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][3] + 1);
                    dp[i][3] = Math.min(dp[i - 1][3], dp[i - 1][2] + 1);
                } else if (obstacles[i] == 2) {
                    dp[i][2] = Integer.MAX_VALUE - 1;
                    dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][3] + 1);
                    dp[i][3] = Math.min(dp[i - 1][3], dp[i - 1][1] + 1);
                } else if (obstacles[i] == 3) {
                    dp[i][3] = Integer.MAX_VALUE - 1;
                    dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][2] + 1);
                    dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1] + 1);
                } else {
                    dp[i][1] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][2], dp[i - 1][3]) + 1);
                    dp[i][2] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][1], dp[i - 1][3]) + 1);
                    dp[i][3] = Math.min(dp[i - 1][3], Math.min(dp[i - 1][1], dp[i - 1][2]) + 1);
                }
            }

            return Math.min(dp[dp.length - 1][1], Math.min(dp[dp.length - 1][2], dp[dp.length - 1][3]));
        }
    }
}
