package com.leetcode.tag.daily.four;

/**
 * 463. 岛屿的周长
 */
public class IslandPerimeter {
    /**
     * 方法一：迭代
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/island-perimeter/solution/dao-yu-de-zhou-chang-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        public int islandPerimeter(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    int cnt = 0;
                    for (int k = 0; k < dx.length; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            // 看其四个方向是否为边界或者水域
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
            return ans;
        }
    }

    /**
     * 方法二：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/island-perimeter/solution/dao-yu-de-zhou-chang-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        public int islandPerimeter(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 1) {
                        ans += dfs(i, j, grid, n, m);
                    }
                }
            }
            return ans;
        }

        public int dfs(int x, int y, int[][] grid, int n, int m) {
            // 递归终止条件
            if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
                // 返回1
                // 不是返回0
                return 1;
            }
            if (grid[x][y] == 2) {
                return 0;
            }
            grid[x][y] = 2;
            int res = 0;
            for (int i = 0; i < 4; ++i) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                res += dfs(tx, ty, grid, n, m);
            }
            return res;
        }
    }

}
