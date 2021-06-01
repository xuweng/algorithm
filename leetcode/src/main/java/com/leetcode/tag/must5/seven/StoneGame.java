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

    class Solution1 {
        public boolean stoneGame(int[] piles) {
            if (piles == null || piles.length == 0) {
                return false;
            }
            // dp[i][j] 表示当剩下的石子堆为下标 i 到下标 j 时，当前玩家与另一个玩家的石子数量之差的最大值
            int[][] dp = new int[piles.length][piles.length];
            for (int i = 0; i < piles.length; i++) {
                // 当 i=j 时，只剩下一堆石子，当前玩家只能取走这堆石子，因此对于所有 0 ≤ i < nums.length，都有 dp[i][i]=piles[i]
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
}
