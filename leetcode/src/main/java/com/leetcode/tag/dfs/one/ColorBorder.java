package com.leetcode.tag.dfs.one;

/**
 * 1034. 边框着色
 * <p>
 * 处理负数.
 * <p>
 * i-1---->i?
 * <p>
 * 第一个维度一般是i-1.第二个维度?
 */
public class ColorBorder {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;

        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
            dfs(grid, r0, c0, color, grid[r0][c0]);

            return grid;
        }

        private void dfs(int[][] grid, int row, int col, int color, int value) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] != value) {
                return;
            }
            visited[row][col] = true;
            grid[row][col] = color;
            for (int i = 0; i < rows.length; i++) {
                dfs(grid, row + rows[i], col + cols[i], color, value);
            }
        }
    }
}
