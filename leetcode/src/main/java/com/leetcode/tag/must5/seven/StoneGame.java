package com.leetcode.tag.must5.seven;

/**
 * 877. 石子游戏
 */
public class StoneGame {
    class Solution {
        public boolean stoneGame(int[] piles) {
            if (piles == null || piles.length == 0) {
                return false;
            }
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
