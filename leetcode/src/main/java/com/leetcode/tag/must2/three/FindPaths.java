package com.leetcode.tag.must2.three;

import java.util.Arrays;

/**
 * 576. 出界的路径数
 */
public class FindPaths {
    /**
     * 先枚举依赖
     * <p>
     * 先枚举步数 先枚举油量
     */
    class Solution {
        int mod = 1000000007;
        int[][] meno;
        int[][] ints = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            meno = new int[m][n];
            for (int[] ints1 : meno) {
                Arrays.fill(ints1, -1);
            }

            return dfs(m, n, maxMove, startRow, startColumn);
        }

        private int dfs(int m, int n, int maxMove, int startRow, int startColumn) {
            if (maxMove < 0) {
                return 0;
            }
            // 上下左右不能移出边界
            if (startRow - maxMove >= 0 && startRow + maxMove < m && startColumn - maxMove >= 0 && startColumn + maxMove < n) {
                return 0;
            }
            // 可以移出边界
            if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
                return 1;
            }
            if (meno[startRow][startColumn] != -1) {
                return meno[startRow][startColumn];
            }
            int sum = 0;
            for (int[] anInt : ints) {
                int nextR = startRow + anInt[0];
                int nextC = startColumn + anInt[1];

                sum += dfs(m, n, maxMove - 1, nextR, nextC);
                sum %= mod;
            }
            meno[startRow][startColumn] = sum;
            return sum;
        }
    }
}
