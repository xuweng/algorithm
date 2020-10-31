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
            if (A[row][col] == 0) {
                return 0;
            }
            A[row][col] = 2;
            int result = 1;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= A.length || c < 0 || c >= A[0].length) {
                    return 0;
                }
                if (A[r][c] == 1) {
                    result += dfs(A, r, c);
                }
            }
            return result;
        }
    }
}
