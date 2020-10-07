package com.leetcode.tag.dfs.one;

/**
 * 542. 01 矩阵
 */
public class UpdateMatrix {
    static class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] used;

        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 1) {
                return new int[0][0];
            }
            used = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < matrix[0].length; i1++) {
                    if (matrix[i][i1] == 1) {
                        matrix[i][i1] = dfs(matrix, i, i1);
                    }
                }
            }
            return matrix;
        }

        private int dfs(int[][] matrix, int row, int col) {
            if (matrix[row][col] == 0) {
                return 0;
            }
            used[row][col] = true;
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || used[r][c]) {
                    continue;
                }
                result = Math.min(result, dfs(matrix, r, c));
            }
            used[row][col] = false;
            return result + 1;
        }
    }

}
