package com.leetcode.tag.must6.one;

/**
 * 877. 石子游戏
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
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }

            return dp[0][piles.length - 1] > 0;
        }
    }

    class Solution1 {
        public boolean stoneGame(int[] piles) {
            int[] dp = new int[piles.length];
            for (int i = 0; i < piles.length; i++) {
                dp[i] = piles[i];
            }
            for (int i = piles.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < piles.length; j++) {
                    dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
                }
            }

            return dp[piles.length - 1] > 0;
        }
    }
}
