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
            visited = new boolean[grid.length][grid[0].length];

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

    /**
     * 作者：m-xy
     * 链接：https://leetcode-cn.com/problems/coloring-a-border/solution/dao-yu-wen-ti-visitedshu-zu-bao-cun-zhuang-tai-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        boolean[][] visited;

        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
            visited = new boolean[grid.length][grid[0].length];

            dfs(grid, r0, c0, color, grid[r0][c0]);

            return grid;
        }

        public void dfs(int[][] grid, int i, int j, int color, int old) {
            //越界返回
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            //此节点已遍历过/此节点不符合要求
            if (visited[i][j] || grid[i][j] != old) {
                return;
            }

            //边界
            if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                grid[i][j] = color;
            } else {
                //四条if判断是否为连通分量的边界，注意visited和边界判断
                if (grid[i - 1][j] != old && !visited[i - 1][j]) {
                    grid[i][j] = color;
                }
                if (grid[i][j - 1] != old && !visited[i][j - 1]) {
                    grid[i][j] = color;
                }
                if (i < grid.length - 1 && grid[i + 1][j] != old && !visited[i + 1][j]) {
                    grid[i][j] = color;
                }
                if (j < grid[0].length - 1 && grid[i][j + 1] != old && !visited[i][j + 1]) {
                    grid[i][j] = color;
                }
            }

            visited[i][j] = true;

            dfs(grid, i + 1, j, color, old);
            dfs(grid, i - 1, j, color, old);
            dfs(grid, i, j + 1, color, old);
            dfs(grid, i, j - 1, color, old);
        }
    }

}
