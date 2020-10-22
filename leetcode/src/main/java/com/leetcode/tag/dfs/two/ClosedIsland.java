package com.leetcode.tag.dfs.two;

/**
 * 1254. 统计封闭岛屿的数目
 */
public class ClosedIsland {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        int[][] visited;

        public int closedIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            visited = new int[grid.length][grid[0].length];
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 || visited[i][j] == 2) {
                        continue;
                    }
                    if (dfs(grid, i, j)) {
                        result++;
                    }
                }
            }
            return result;
        }

        private boolean dfs(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return false;
            }
            if (visited[row][col] == 1 || grid[row][col] == 1) {
                return true;
            }
            visited[row][col] = 1;
            boolean result = true;
            for (int i = 0; i < rows.length; i++) {
                result = result && dfs(grid, row + rows[i], col + cols[i]);
            }
            visited[row][col] = 2;
            return result;
        }
    }
}
