package com.leetcode.tag.dfs.three;

/**
 * 1020. 飞地的数量
 * <p>
 * 学到什么东西.学到什么东西.学到什么东西.学到什么东西.
 * <p>
 * 有向图.无向图.环.缓存.
 */
public class NumEnclaves {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};

        public int numEnclaves(int[][] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 1) {
                        result += dfs(A, i, j);
                    }
                }
            }
            return result;
        }

        private int dfs(int[][] A, int row, int col) {
            if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || A[row][col] == 2) {
                return Integer.MAX_VALUE;
            }
            if (A[row][col] == 0) {
                return 0;
            }
            A[row][col] = 2;
            int result = 1;
            for (int i : rows) {
                int d = dfs(A, row + rows[i], col + cols[i]);
                if (d == Integer.MAX_VALUE) {
                    return 0;
                }
                result += d;
            }
            return result;
        }
    }
}
