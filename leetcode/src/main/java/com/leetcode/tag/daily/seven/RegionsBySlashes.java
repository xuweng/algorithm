package com.leetcode.tag.daily.seven;

/**
 * 959. 由斜杠划分区域
 */
public class RegionsBySlashes {
    /**
     * 方法：并查集
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/you-xie-gang-hua-fen-qu-yu-by-leetcode-67xb/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int regionsBySlashes(String[] grid) {
            int N = grid.length;
            int size = 4 * N * N;

            UnionFind unionFind = new UnionFind(size);
            for (int i = 0; i < N; i++) {
                char[] row = grid[i].toCharArray();
                for (int j = 0; j < N; j++) {
                    // 二维网格转换为一维表格
                    int index = 4 * (i * N + j);
                    char c = row[j];
                    // 单元格内合并
                    if (c == '/') {
                        // 合并 0、3，合并 1、2
                        unionFind.union(index, index + 3);
                        unionFind.union(index + 1, index + 2);
                    } else if (c == '\\') {
                        // 合并 0、1，合并 2、3
                        unionFind.union(index, index + 1);
                        unionFind.union(index + 2, index + 3);
                    } else {
                        unionFind.union(index, index + 1);
                        unionFind.union(index + 1, index + 2);
                        unionFind.union(index + 2, index + 3);
                    }

                    // 单元格间合并
                    // 向右合并：1（当前）、3（右一列）
                    if (j + 1 < N) {
                        unionFind.union(index + 1, 4 * (i * N + j + 1) + 3);
                    }
                    // 向下合并：2（当前）、0（下一行）
                    if (i + 1 < N) {
                        unionFind.union(index + 2, 4 * ((i + 1) * N + j));
                    }
                }
            }
            return unionFind.getCount();
        }

        class UnionFind {
            private int[] parent;
            private int count;

            public int getCount() {
                return count;
            }

            public UnionFind(int n) {
                this.count = n;
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                while (x != parent[x]) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return;
                }

                parent[rootX] = rootY;
                count--;
            }
        }
    }

}
