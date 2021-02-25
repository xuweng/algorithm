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
                min = Math.min(min, dfs(matrix, matrix.length - 1, i));
            }

            return min;
        }

        private int dfs(int[][] matrix, int row, int col) {
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
                return Integer.MAX_VALUE;
            }
            if (row == 0) {
                return matrix[row][col];
            }

            int min1 = dfs(matrix, row - 1, col - 1);
            int min2 = dfs(matrix, row - 1, col);
            int min3 = dfs(matrix, row - 1, col + 1);
            return Math.min(min1, Math.min(min2, min3)) + matrix[row][col];
        }
    }

    class Solution1 {
        int[][] meno;

        public int minFallingPathSum(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            meno = new int[matrix.length][matrix[0].length];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < matrix[0].length; i++) {
                min = Math.min(min, dfs(matrix, matrix.length - 1, i));
            }

            return min;
        }

        private int dfs(int[][] matrix, int row, int col) {
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
                return Integer.MAX_VALUE;
            }
            if (row == 0) {
                return matrix[row][col];
            }
            if (matrix[row][col] != 0) {
                return matrix[row][col];
            }

            int min1 = dfs(matrix, row - 1, col - 1);
            int min2 = dfs(matrix, row - 1, col);
            int min3 = dfs(matrix, row - 1, col + 1);
            meno[row][col] = Math.min(min1, Math.min(min2, min3)) + matrix[row][col];

            return meno[row][col];
        }
    }
}
