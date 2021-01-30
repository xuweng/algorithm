package com.leetcode.tag.daily.seven;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 778. 水位上升的泳池中游泳
 * <p>
 * 看懂题目 看懂题目 看懂题目
 * <p>
 * 差值 权重
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
                // 这里visited是一次性 一次dfs一个visited
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
         * <p>
         * 连接所有<=threshold的结点
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
                // 判断邻接结点
                // 边界 没有访问 附加条件
                // grid[newX][newY] <= threshold
                if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= threshold) {
                    if (newX == N - 1 && newY == N - 1) {
                        return true;
                    }

                    // 找到一个就返回
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

    /**
     * 方法二：并查集
     */
    class Solution1 {
        private int N;
        public final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int swimInWater(int[][] grid) {
            this.N = grid.length;

            int len = N * N;
            // 下标：方格的高度，值：对应在方格中的坐标
            int[] index = new int[len];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    index[grid[i][j]] = getIndex(i, j);
                }
            }

            UnionFind unionFind = new UnionFind(len);
            for (int i = 0; i < len; i++) {
                // 恢复二维坐标
                int x = index[i] / N;
                int y = index[i] % N;

                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (inArea(newX, newY) && grid[newX][newY] <= i) {
                        unionFind.union(index[i], getIndex(newX, newY));
                    }

                    if (unionFind.isConnected(0, len - 1)) {
                        return i;
                    }
                }
            }
            return -1;
        }

        /**
         * 二维转一维
         *
         * @param x
         * @param y
         * @return
         */
        private int getIndex(int x, int y) {
            return x * N + y;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < N && y >= 0 && y < N;
        }

        class UnionFind {
            private int[] parent;

            public UnionFind(int n) {
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int root(int x) {
                while (x != parent[x]) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public boolean isConnected(int x, int y) {
                return root(x) == root(y);
            }

            public void union(int p, int q) {
                if (isConnected(p, q)) {
                    return;
                }
                parent[root(p)] = root(q);
            }
        }
    }

    /**
     * 方法三：Dijkstra 算法
     */
    class Solution2 {
        // Dijkstra 算法（应用前提：没有负权边，找单源最短路径）
        public int swimInWater(int[][] grid) {
            int n = grid.length;

            Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
            minHeap.offer(new int[]{0, 0});

            boolean[][] visited = new boolean[n][n];
            // distTo[i][j] 表示：到顶点 [i, j] 须要等待的最少的时间
            int[][] distTo = new int[n][n];
            for (int[] row : distTo) {
                Arrays.fill(row, n * n);
            }
            distTo[0][0] = grid[0][0];

            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while (!minHeap.isEmpty()) {
                // 找最短的边
                int[] front = minHeap.poll();
                int currentX = front[0];
                int currentY = front[1];
                if (visited[currentX][currentY]) {
                    continue;
                }

                // 确定最短路径顶点
                visited[currentX][currentY] = true;
                if (currentX == n - 1 && currentY == n - 1) {
                    return distTo[n - 1][n - 1];
                }

                // 更新
                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];
                    if (inArea(newX, newY, n) && !visited[newX][newY] &&
                            Math.max(distTo[currentX][currentY], grid[newX][newY]) < distTo[newX][newY]) {
                        // 更新距离表
                        distTo[newX][newY] = Math.max(distTo[currentX][currentY], grid[newX][newY]);
                        minHeap.offer(new int[]{newX, newY});
                    }
                }
            }
            return -1;
        }

        private boolean inArea(int x, int y, int n) {
            return x >= 0 && x < n && y >= 0 && y < n;
        }
    }

}
