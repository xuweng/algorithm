package com.leetcode.tag.dfs.three;

/**
 * 200. 岛屿数量
 */
public class NumIslands {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != '1') {
                        continue;
                    }
                    dfs(grid, i, j);
                    result++;
                }
            }

            return result;
        }

        private void dfs(char[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
                return;
            }
            grid[row][col] = '2';
            for (int i = 0; i < rows.length; i++) {
                dfs(grid, row + rows[i], col + cols[i]);
            }
        }
    }
}
