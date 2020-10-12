package com.leetcode.tag.dfs.one;

import java.util.stream.IntStream;

/**
 * 959. 由斜杠划分区域
 * <p>
 * 预先处理候选集
 * <p>
 * 从左到右顺序选择
 * <p>
 * 选择策略
 * <p>
 * 标记不回溯,相当visited.
 * <p>
 * 十分钟.十分钟.十分钟.
 */
public class RegionsBySlashes {
    /**
     * 方法 1：并查集
     * <p>
     * 为了找到图中连通块的数量，我们可以使用深度优先搜索或者并查集算法。问题的难点在于如何识别出整张图。
     * <p>
     * 这道题本质上是计算连通分量个数，难点在于理解题意以及确定哪些元素是相连的．
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/you-xie-gang-hua-fen-qu-yu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            DSU dsu = new DSU(4 * n * n);
            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    int root = 4 * (r * n + c);
                    char val = grid[r].charAt(c);
                    if (val != '\\') {
                        dsu.union(root, root + 1);
                        dsu.union(root + 2, root + 3);
                    }
                    if (val != '/') {
                        dsu.union(root, root + 2);
                        dsu.union(root + 1, root + 3);
                    }

                    // north south
                    if (r + 1 < n) {
                        dsu.union(root + 3, (root + 4 * n));
                    }
                    if (r - 1 >= 0) {
                        dsu.union(root, (root - 4 * n) + 3);
                    }
                    // east west
                    if (c + 1 < n) {
                        dsu.union(root + 2, (root + 4) + 1);
                    }
                    if (c - 1 >= 0) {
                        dsu.union(root + 1, (root - 4) + 2);
                    }
                }
            }

            //计算连通分量个数
            return (int) IntStream.range(0, 4 * n * n).filter(x -> dsu.find(x) == x).count();
        }
    }

    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    /**
     * dfs
     */
    class Solution1 {
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            boolean[][] graph = new boolean[n * 3][n * 3];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i].charAt(j) == '/') {
                        graph[i * 3][j * 3 + 2] = true;
                        graph[i * 3 + 1][j * 3 + 1] = true;
                        graph[i * 3 + 2][j * 3] = true;
                    } else if (grid[i].charAt(j) == '\\') {
                        graph[i * 3][j * 3] = true;
                        graph[i * 3 + 1][j * 3 + 1] = true;
                        graph[i * 3 + 2][j * 3 + 2] = true;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < n * 3; ++i) {
                for (int j = 0; j < n * 3; ++j) {
                    if (graph[i][j]) {
                        continue;
                    }
                    dfs(graph, i, j);
                    res++;
                }
            }
            return res;

        }

        private void dfs(boolean[][] graph, int i, int j) {
            int n = graph.length;
            //数组边界检查
            //是否访问
            if (i < 0 || i >= n || j < 0 || j >= n || graph[i][j]) {
                return;
            }
            graph[i][j] = true;
            //上下左右
            dfs(graph, i - 1, j);
            dfs(graph, i + 1, j);
            dfs(graph, i, j - 1);
            dfs(graph, i, j + 1);
        }
    }

}
