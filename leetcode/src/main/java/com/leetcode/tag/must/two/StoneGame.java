package com.leetcode.tag.must.two;

/**
 * 877. 石子游戏
 */
public class StoneGame {
    class Solution {
        public boolean stoneGame(int[] piles) {
            if (piles == null || piles.length == 0) {
                return false;
            }
            int[][] dp = new int[piles.length][piles.length];
            for (int i = piles.length - 1; i >= 0; i--) {
                for (int j = i; j < piles.length; j++) {
                    if (i == j) {
                        dp[i][j] = piles[i];
                    } else {
                        dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                    }
                }
            }

            return dp[0][piles.length - 1] > 0;
        }
    }
}
