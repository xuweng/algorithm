package com.leetcode.tag.must2.two;

import java.util.Arrays;

/**
 * 576. 出界的路径数
 */
public class FindPaths {
    int row;
    int col;

    /**
     * 变化 位置 油量
     * <p>
     * 变化 坐标 步数
     */
    class Solution {
        int mod = 1000000007;
        int[][][] meno;
        int[][] rows = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int findPaths(int m, int n, int N, int i, int j) {
            meno = new int[m][n][N + 1];
            for (int[][] ints : meno) {
                for (int[] anInt : ints) {
                    Arrays.fill(anInt, -1);
                }
            }

            return dfs(m, n, N, i, j);
        }

        private int dfs(int m, int n, int N, int i, int j) {
            if (N < 0) {
                return 0;
            }
            // 当前位置上下左右不能移出边界
            if (i + N < m && i - N >= 0 && j + N < n && j - N >= 0) {
                return 0;
            }
            // 边界外
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return 1;
            }
            if (meno[i][j][N] != -1) {
                return meno[i][j][N];
            }
            int sum = 0;
            for (int[] ints : rows) {
                int nextI = i + ints[0];
                int nextJ = j + ints[1];
                sum += dfs(m, n, N - 1, nextI, nextJ);
                sum %= mod;
            }
            meno[i][j][N] = sum;
            return sum;
        }
    }

    private int getIndex(int i, int j) {
        return i * col + j;
    }

    private int[] parse(int index) {
        return new int[]{index / col, index % col};
    }
}
