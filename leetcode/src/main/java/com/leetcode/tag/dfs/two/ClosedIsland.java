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

        /**
         * visited[row][col] == 2 访问完成应该返回true还是false?
         *
         * @param grid
         * @param row
         * @param col
         * @return
         */
        private boolean dfs(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] == 2) {
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

    class Solution2 {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};

        public int closedIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        continue;
                    }
                    if (dfs(grid, i, j)) {
                        result++;
                    }
                }
            }
            return result;
        }

        /**
         * visited[row][col] == 2 访问完成应该返回true还是false?
         *
         * @param grid
         * @param row
         * @param col
         * @return
         */
        private boolean dfs(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return false;
            }
            if (grid[row][col] == 1) {
                return true;
            }
            // 修改原数组
            grid[row][col] = 1;
            boolean[] result = new boolean[rows.length];
            for (int i = 0; i < rows.length; i++) {
                result[i] = dfs(grid, row + rows[i], col + cols[i]);
            }
            return result[0] && result[1] && result[2] && result[3];
        }
    }

    /**
     * 厉害
     */
    class Solution3 {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};

        public int closedIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        continue;
                    }
                    result += dfs(grid, i, j);
                }
            }
            return result;
        }

        private int dfs(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return 0;
            }
            if (grid[row][col] == 1) {
                return 1;
            }
            grid[row][col] = 1;
            int result = 1;
            for (int i = 0; i < rows.length; i++) {
                result = Math.min(result, dfs(grid, row + rows[i], col + cols[i]));
            }
            return result;
        }
    }

    /**
     * dfs
     * <p>
     * 作者：liuchuan1992
     * 链接：https://leetcode-cn.com/problems/number-of-closed-islands/solution/dfsjie-jue-by-liuchuan1992/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int closedIsland(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int res = 0;
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (grid[i][j] == 0) {
                        if (dfs(grid, i, j)) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }

        private boolean dfs(int[][] grid, int i, int j) {
            int rows = grid.length;
            int cols = grid[0].length;
            if (i < 0 || j < 0 || i >= rows || j >= cols) {
                return false;
            }
            if (grid[i][j] == 1) {
                return true;
            }
            grid[i][j] = 1;
            boolean up = dfs(grid, i - 1, j);
            boolean down = dfs(grid, i + 1, j);
            boolean left = dfs(grid, i, j - 1);
            boolean right = dfs(grid, i, j + 1);
            return up && down && left && right;
        }
    }

}
