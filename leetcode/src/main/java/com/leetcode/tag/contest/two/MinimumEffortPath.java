package com.leetcode.tag.contest.two;

/**
 * 5548. 最小体力消耗路径
 */
public class MinimumEffortPath {
    /**
     * 超出时间限制
     */
    static class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;
        int result = Integer.MAX_VALUE;

        public int minimumEffortPath(int[][] heights) {
            visited = new boolean[heights.length][heights[0].length];

            dfs(heights, 0, 0, 0);

            return result;
        }

        public void dfs(int[][] heights, int row, int col, int cha) {
            if (row == heights.length - 1 && col == heights[0].length - 1) {
                result = Math.min(result, cha);
                return;
            }
            visited[row][col] = true;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c]) {
                    continue;
                }
                dfs(heights, r, c, Math.max(cha, Math.abs(heights[r][c] - heights[row][col])));
            }
            visited[row][col] = false;

        }
    }

    /**
     * dfs如何缓存
     */
    class Solution1 {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;
        int[][] meno;
        int result = Integer.MAX_VALUE;

        public int minimumEffortPath(int[][] heights) {
            visited = new boolean[heights.length][heights[0].length];
            meno = new int[heights.length][heights[0].length];

            dfs(heights, 0, 0, heights.length - 1, heights[0].length - 1);

            return result;
        }

        public int dfs(int[][] heights, int row, int col, int endR, int endC) {
            if (meno[row][col] != 0) {
                return meno[row][col];
            }
            if (row == endR && col == endC) {
                meno[row][col] = heights[row][col];
                return heights[row][col];
            }
            visited[row][col] = true;
            int re = 0;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c]) {
                    continue;
                }

                re = Math.max(re, Math.max(dfs(heights, r, c, endR, endC), Math.abs(heights[r][c] - heights[row][col])));
            }
            visited[row][col] = false;
            meno[row][col] = re;
            return re;
        }
    }

    /**
     * 二分查找+DFS
     * <p>
     * 最大值最小化问题
     * <p>
     * 作者：soap88
     * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort/solution/er-fen-cha-zhao-dfs-by-soap88/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int minimumEffortPath(int[][] heights) {
            int left = 0;
            int right = 1000000;
            //二分查找搜索最小值
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (!dfs(0, 0, mid, heights, new boolean[heights.length][heights[0].length])) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        /**
         * 检查是否存在一条从(x,y)到终点的路径，该路径中相邻顶点绝对值差不大于max
         *
         * @param x
         * @param y
         * @param max
         * @param h
         * @param visited
         * @return
         */
        boolean dfs(int x, int y, int max, int[][] h, boolean[][] visited) {
            if (x == h.length - 1 && y == h[0].length - 1) {
                // 到达终点
                return true;
            }
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= h.length || ny < 0 || ny >= h[0].length || visited[nx][ny]
                        || Math.abs(h[nx][ny] - h[x][y]) > max) {
                    continue;
                }
                if (dfs(nx, ny, max, h, visited)) {
                    return true;
                }
            }
            return false;
        }

    }
}
