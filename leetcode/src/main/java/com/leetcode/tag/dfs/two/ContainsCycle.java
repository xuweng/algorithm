package com.leetcode.tag.dfs.two;

import java.util.Arrays;

/**
 * 1559. 二维网格图中探测环
 * <p>
 * dp.dp.
 * <p>
 * 画图.画图.画图.画图.画图.
 * <p>
 * 示例.示例.示例.示例.示例.示例.
 * <p>
 * dp.dp.dp.dp.dp.dp.dp.dp.dp.
 * <p>
 * dp.用已经计算的推导没有计算的..找到之前已经计算过的.如何遍历?顺序计算.计算顺序.
 */
public class ContainsCycle {
    /**
     * 方法一：并查集
     * <p>
     * 将其中的每个位置看成一个节点，任意两个上下左右相邻且值相同的节点之间有一条无向边
     * <p>
     * 那么 grid 中的一个环就对应着我们构造出的图中的一个环
     * <p>
     * 构造图.点和边.构造图.点和边.构造图.点和边.构造图.点和边.
     * <p>
     * 常用的判断无向图中是否有环的方法有深度优先搜索和广度优先搜索，但这里我们会介绍一种基于并查集的判断方法。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/detect-cycles-in-2d-grid/solution/er-wei-wang-ge-tu-zhong-tan-ce-huan-by-leetcode-so/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean containsCycle(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            UnionFind uf = new UnionFind(m * n);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                        if (!uf.findAndUnite(i * n + j, (i - 1) * n + j)) {
                            // 两个点都在同一个集合.不用合并.
                            return true;
                        }
                    }
                    if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                        if (!uf.findAndUnite(i * n + j, i * n + j - 1)) {
                            // 两个点都在同一个集合.不用合并.
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int n;
        int setCount;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
            this.n = n;
            setCount = n;
        }

        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        }

        public void unite(int x, int y) {
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            --setCount;
        }

        /**
         * 是否合并
         *
         * @param x
         * @param y
         * @return
         */
        public boolean findAndUnite(int x, int y) {
            int parentX = findset(x);
            int parentY = findset(y);
            if (parentX != parentY) {
                unite(parentX, parentY);
                return true;
            }
            return false;
        }
    }

    class Solution1 {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        int[][] visited;

        public boolean containsCycle(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return false;
            }
            visited = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (visited[i][j] == 2) {
                        continue;
                    }
                    if (dfs(grid, i, j, -1, -1, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] grid, int row, int col, int parentR, int parentC, int path) {
            if (visited[row][col] == 1) {
                return path >= 4;
            }
            visited[row][col] = 1;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[row][col] != grid[r][c] || (r == parentR && c == parentC)) {
                    continue;
                }
                if (dfs(grid, r, c, row, col, path + 1)) {
                    return true;
                }
            }
            visited[row][col] = 2;
            return false;
        }
    }

}
