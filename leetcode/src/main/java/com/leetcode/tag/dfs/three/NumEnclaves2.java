package com.leetcode.tag.dfs.three;

/**
 * 1020. 飞地的数量
 */
public class NumEnclaves2 {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};

        public int numEnclaves(int[][] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            for (int i = 0; i < A[0].length; i++) {
                if (A[0][i] == 1) {
                    dfs(A, 0, i);
                }
                if (A[A.length - 1][i] == 1) {
                    dfs(A, A.length - 1, i);
                }
            }
            for (int i = 0; i < A.length; i++) {
                if (A[i][0] == 1) {
                    dfs(A, i, 0);
                }
                if (A[i][A[0].length - 1] == 1) {
                    dfs(A, i, A[0].length - 1);
                }
            }
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 1) {
                        result++;
                    }
                }
            }
            return result;
        }

        private void dfs(int[][] A, int row, int col) {
            if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || A[row][col] == 0) {
                return;
            }
            A[row][col] = 0;
            for (int i = 0; i < rows.length; i++) {
                dfs(A, row + rows[i], col + cols[i]);
            }
        }
    }
}
