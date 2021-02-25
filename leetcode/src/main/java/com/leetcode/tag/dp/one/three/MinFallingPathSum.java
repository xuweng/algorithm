package com.leetcode.tag.dp.one.three;

/**
 * 931. 下降路径最小和
 */
public class MinFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < matrix[0].length; i++) {
                min = Math.max(min, dfs(matrix, matrix.length - 1, i));
            }

            return min;
        }

        private int dfs(int[][] matrix, int row, int col) {
            if (row == 0) {
                return matrix[row][col];
            }
            if (row < 0 || col < 0) {
                return Integer.MAX_VALUE;
            }
            int min1 = dfs(matrix, row - 1, col - 1);
            int min2 = dfs(matrix, row - 1, col);
            int min3 = dfs(matrix, row - 1, col + 1);
            return Math.min(min1, Math.min(min2, min3));
        }
    }
}
