package com.leetcode.tag.must5.ten;

/**
 * 877. 石子游戏
 * <p>
 * ij模型 ij模型 ij模型
 * <p>
 * left越界 left越界 left越界
 */
public class StoneGame {
    class Solution {
        public boolean stoneGame(int[] piles) {
            int[][] dp = new int[piles.length][piles.length];
            for (int i = 0; i < piles.length; i++) {
                dp[i][i] = piles[i];
            }
            for (int i = piles.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < piles.length; j++) {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] + dp[i][j - 1]);
                }
            }

            return dp[0][piles.length - 1] > 0;
        }
    }
}
