package com.leetcode.tag.daily.seven;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1631. 最小体力消耗路径
 */
public class MinimumEffortPath {
    class Solution {
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

        //检查是否存在一条从(x,y)到终点的路径，该路径中相邻顶点绝对值差不大于max
        boolean dfs(int x, int y, int max, int[][] h, boolean[][] visited) {
            if (x == h.length - 1 && y == h[0].length - 1) {
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

    /**
     * 方法一：二分查找
     * <p>
     * 广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort/solution/zui-xiao-ti-li-xiao-hao-lu-jing-by-leetc-3q2j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            int left = 0, right = 999999, ans = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{0, 0});
                boolean[] seen = new boolean[m * n];
                seen[0] = true;
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    int x = cell[0], y = cell[1];
                    for (int i = 0; i < 4; ++i) {
                        int nx = x + dirs[i][0];
                        int ny = y + dirs[i][1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                            queue.offer(new int[]{nx, ny});
                            seen[nx * n + ny] = true;
                        }
                    }
                }
                if (seen[m * n - 1]) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

}
