package com.leetcode.tag.daily.seven;

import java.util.*;

/**
 * 1631. 最小体力消耗路径
 * <p>
 * https://leetcode-cn.com/problems/path-with-minimum-effort/solution/duo-tu-xiang-xi-fen-xi-jie-ti-si-lu-fen-7z89x/
 * <p>
 * 看懂题目 看懂题目 看懂题目
 * <p>
 * 差值的绝对值转化为权重 图论问题 有权图
 * <p>
 * 并查集作用： 判断两点是否连通 连通性
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
                // 二分
                int mid = (left + right) / 2;
                // bfs
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
                // 二分
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

    /**
     * 方法二：并查集
     * <p>
     * https://leetcode-cn.com/problems/path-with-minimum-effort/solution/duo-tu-xiang-xi-fen-xi-jie-ti-si-lu-fen-7z89x/
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort/solution/zui-xiao-ti-li-xiao-hao-lu-jing-by-leetc-3q2j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            //edges[i] 是个 [边的第一个顶点，边的第二个顶点,边的权重] 三元组
            //需要对边的权重排序
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    //把二维左边转成了一维，即第 i 行第 j 列映射成了 i * N + j
                    int id = i * n + j;
                    if (i > 0) {
                        edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                    }
                    if (j > 0) {
                        edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                    }
                }
            }
            edges.sort(Comparator.comparingInt(edge -> edge[2]));

            UnionFind uf = new UnionFind(m * n);
            int ans = 0;
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1], v = edge[2];
                // 连接x，y
                uf.unite(x, y);
                // 判断最左上，最右下是否连接
                if (uf.connected(0, m * n - 1)) {
                    ans = v;
                    break;
                }
            }
            return ans;
        }
    }

    // 并查集模板
    class UnionFind {
        int[] parent;
        int[] size;
        int n;
        // 当前连通分量数目
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        }

        public boolean unite(int x, int y) {
            x = findset(x);
            y = findset(y);
            if (x == y) {
                return false;
            }
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            // y连接到x
            parent[y] = x;
            size[x] += size[y];
            --setCount;
            return true;
        }

        public boolean connected(int x, int y) {
            x = findset(x);
            y = findset(y);
            return x == y;
        }
    }

    /**
     * Dijkstra 算法
     * <p>
     * bfs+优先队列
     */
    class Solution3 {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            // 优先队列
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2]));
            pq.offer(new int[]{0, 0, 0});

            // 距离表
            int[] dist = new int[m * n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            boolean[] seen = new boolean[m * n];

            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                int x = edge[0], y = edge[1], d = edge[2];
                int id = x * n + y;
                if (seen[id]) {
                    continue;
                }
                if (x == m - 1 && y == n - 1) {
                    break;
                }
                seen[id] = true;
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && Math.max(d, Math.abs(heights[x][y] - heights[nx][ny])) < dist[nx * n + ny]) {
                        dist[nx * n + ny] = Math.max(d, Math.abs(heights[x][y] - heights[nx][ny]));
                        pq.offer(new int[]{nx, ny, dist[nx * n + ny]});
                    }
                }
            }

            return dist[m * n - 1];
        }
    }

}
