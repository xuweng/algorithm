package com.leetcode.tag.dfs.two;

/**
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (visited[i][j] || grid[i][j] == 0) {
                        continue;
                    }
                    max = Math.max(max, dfs(grid, i, j));
                }
            }

            return max;
        }

        private int dfs(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
                return 0;
            }
            visited[row][col] = true;
            int result = 1;
            for (int i = 0; i < rows.length; i++) {
                result += dfs(grid, row + rows[i], col + cols[i]);
            }

            return result;
        }
    }
}
