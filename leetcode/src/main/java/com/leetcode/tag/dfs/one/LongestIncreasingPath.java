package com.leetcode.tag.dfs.one;

/**
 * 329. 矩阵中的最长递增路径
 */
public class LongestIncreasingPath {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;
        int count;
        int result;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            visited = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dfs(matrix, i, j, 1);
                    result = Math.max(result, count);
                    count = 0;
                }
            }

            return result;
        }

        private void dfs(int[][] matrix, int row, int col, int count) {
            this.count = Math.max(this.count, count);
            visited[row][col] = true;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || visited[r][c] || matrix[r][c] <= matrix[row][col]) {
                    continue;
                }
                dfs(matrix, r, c, count + 1);
            }
            visited[row][col] = false;
        }
    }
}
