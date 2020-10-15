package com.leetcode.tag.dfs.two;

/**
 * 695. 岛屿的最大面积
 * <p>
 * 难点:矩阵缓存
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
            visited = new boolean[grid.length][grid[0].length];
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
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

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            for (int i = 0; i != grid.length; ++i) {
                for (int j = 0; j != grid[0].length; ++j) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
            return ans;
        }

        public int dfs(int[][] grid, int curI, int curJ) {
            if (curI < 0 || curJ < 0 || curI == grid.length || curJ == grid[0].length || grid[curI][curJ] != 1) {
                return 0;
            }
            //修改矩阵.作用类似visited.
            grid[curI][curJ] = 0;
            int[] di = {0, 0, 1, -1};
            int[] dj = {1, -1, 0, 0};
            int ans = 1;
            for (int index = 0; index != 4; ++index) {
                int nextI = curI + di[index], nextJ = curJ + dj[index];
                ans += dfs(grid, nextI, nextJ);
            }
            return ans;
        }
    }

}
