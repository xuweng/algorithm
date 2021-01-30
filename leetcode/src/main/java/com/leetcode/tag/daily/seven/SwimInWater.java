package com.leetcode.tag.daily.seven;

/**
 * 778. 水位上升的泳池中游泳
 */
public class SwimInWater {
    /**
     * 方法一：二分查找 + 遍历
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/swim-in-rising-water/solution/shui-wei-shang-sheng-de-yong-chi-zhong-y-862o/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        private int N;
        public final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int swimInWater(int[][] grid) {
            this.N = grid.length;

            int left = 0;
            int right = N * N - 1;
            while (left < right) {
                // left + right 不会溢出
                // 二维矩阵，这里mid是值，不是下标
                int mid = (left + right) / 2;
                boolean[][] visited = new boolean[N][N];
                if (grid[0][0] <= mid && dfs(grid, 0, 0, visited, mid)) {
                    // mid 可以，尝试 mid 小一点是不是也可以呢？下一轮搜索的区间 [left, mid]
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        /**
         * 使用深度优先遍历得到从 (x, y) 开始向四个方向的所有小于等于 threshold 且与 (x, y) 连通的结点
         *
         * @param grid
         * @param x
         * @param y
         * @param visited
         * @param threshold
         * @return
         */
        private boolean dfs(int[][] grid, int x, int y, boolean[][] visited, int threshold) {
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= threshold) {
                    if (newX == N - 1 && newY == N - 1) {
                        return true;
                    }

                    if (dfs(grid, newX, newY, visited, threshold)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < N && y >= 0 && y < N;
        }
    }

}
