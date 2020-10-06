package com.leetcode.tag.dfs.one;

/**
 * 1391. 检查网格中是否存在有效路径
 * <p>
 * 十分钟看答案.
 */
public class HasValidPath {
    /**
     * 静态连通性
     * <p>
     * 如果题目中先给定了整个图（例如本题通过二维数组 grid 直接给出了整个网格的信息），
     * <p>
     * 再给出关于连通性的询问（例如本题询问起点到终点是否存在一条路径），那么称其为「静态连通性」。
     * <p>
     * 其相反的定义为「动态连通性」，即图的信息和关于连通性的询问是交替给出的。换句话说，在给出一次关于连通性的询问后，
     * <p>
     * 还可以修改图的一部分，这样就是「动态连通性」
     * <p>
     * 对于静态连通性的题目，一般来说可以使用深度优先搜索、广度优先搜索以及并查集来实现。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid/solution/jian-cha-wang-ge-zhong-shi-fou-cun-zai-you-xiao-lu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        // 定义并查集数据结构
        class UnionFind {
            int[] parents;
            int[] ranks;

            public UnionFind(int totalNum) {
                parents = new int[totalNum];
                ranks = new int[totalNum];
                for (int i = 0; i < totalNum; i++) {
                    parents[i] = i;
                    ranks[i] = 1;
                }
            }

            private int find(int x) {
                if (parents[x] == x) {
                    return x;
                }
                return parents[x] = find(parents[x]);
            }

            private void union(int x, int y) {
                int first = find(x);
                int second = find(y);
                if (first == second) {
                    return;
                }
                if (ranks[first] > ranks[second]) {
                    parents[second] = first;
                } else if (ranks[second] > ranks[first]) {
                    parents[first] = second;
                } else {
                    parents[second] = first;
                    ranks[second] += 1;
                }
            }

            private boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }
        }

        int rows;
        int cols;
        UnionFind uf;
        int[] patterns = {0, 0b1010, 0b0101, 0b1100, 0b0110, 0b1001, 0b0011};
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public boolean hasValidPath(int[][] grid) {
            if (grid == null) {
                return false;
            }
            rows = grid.length;
            cols = grid[0].length;
            uf = new UnionFind(rows * cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    handler(grid, i, j);
                }
            }
            return uf.isConnected(getPosition(0, 0), getPosition(rows - 1, cols - 1));
        }

        private void handler(int[][] grid, int x, int y) {
            int pattern = patterns[grid[x][y]];
            for (int i = 0; i < 4; i++) {
                int i1 = 1 << i;
                if ((pattern & i1) == i1) {
                    int newX = x + directions[i][0];
                    int newY = y + directions[i][1];
                    boolean withinBoundary = newX >= 0 && newX < rows && newY >= 0 && newY < cols;
                    int i2 = 1 << ((i + 2) % 4);
                    if (withinBoundary && ((patterns[grid[newX][newY]] & i2) == i2)) {
                        uf.union(getPosition(x, y), getPosition(newX, newY));
                    }
                }
            }
        }

        private int getPosition(int i, int j) {
            return i * cols + j;
        }
    }
}
