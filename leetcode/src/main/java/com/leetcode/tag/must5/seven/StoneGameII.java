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
 * <p>
 * 区间dp 区间dp 区间dp
 * <p>
 * 回文 区间dp 回文 区间dp 区间dp
 * <p>
 * 最大差值 最大差值 最大差值 最大差值
 * <p>
 * 1个 k个
 * <p>
 * 计算1个------》计算k个
 */
public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int len = piles.length, sum = 0;
        // dp[i][j]表示剩余[i : len - 1]堆时，M = j的情况下，先取的人能获得的最多石子数
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    // i + 2M >= len, dp[i][M] = sum[i : len - 1], 剩下的堆数能够直接全部取走，那么最优的情况就是剩下的石子总和
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
