package com.leetcode.tag.must5.seven;

/**
 * 1140. 石子游戏 II
 * <p>
 * 区间dp 区间dp 区间dp
 * <p>
 * 区间dp 区间dp 区间dp
 * <p>
 * 区间dp 区间dp 区间dp
 * <p>
 * 左右跳 左右跳 左右跳
 * <p>
 * 左右跳 左右跳 左右跳
 */
public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
