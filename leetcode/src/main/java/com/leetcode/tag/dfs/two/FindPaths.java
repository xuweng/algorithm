package com.leetcode.tag.dfs.two;

import java.util.Arrays;

/**
 * 576. 出界的路径数
 * <p>
 * 十分钟.十分钟.十分钟.十分钟.
 * <p>
 * 矩阵缓存.矩阵缓存.矩阵缓存.
 */
public class FindPaths {
    /**
     * 记忆化搜索
     */
    class Solution {
        private final int[][] mp = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        private int mod = 1000000007;
        int[][][] dp;

        public int findPaths(int m, int n, int N, int i, int j) {
            dp = new int[m][n][N + 1];

            for (int p = 0; p < m; p++) {
                for (int q = 0; q < n; q++) {
                    Arrays.fill(dp[p][q], -1);
                }
            }
            return f(m, n, N, i, j);
        }

        private int f(int m, int n, int N, int row, int col) {
            if (N < 0) {
                return 0;
            }
            //如果 上下左右 一直 直走 都不能到达边界，那么无需继续走下去
            if (row + N < m && row - N >= 0 && col + N < n && col - N >= 0) {
                return 0;
            }
            //移出边界.
            if (row < 0 || row >= m || col < 0 || col >= n) {
                return 1;
            }
            if (dp[row][col][N] != -1) {
                return dp[row][col][N];
            }
            int ans = 0;
            //上下左右4个方向累加.不是最大值.
            for (int[] ints : mp) {
                ans = (ans % mod + f(m, n, N - 1, row + ints[0], col + ints[1]) % mod) % mod;
            }
            return dp[row][col][N] = ans;
        }
    }
}
