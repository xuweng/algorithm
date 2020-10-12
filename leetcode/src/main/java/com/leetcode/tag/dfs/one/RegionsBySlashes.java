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
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/you-xie-gang-hua-fen-qu-yu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int regionsBySlashes(String[] grid) {
            int N = grid.length;
            DSU dsu = new DSU(4 * N * N);
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    int root = 4 * (r * N + c);
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
                    if (r + 1 < N) {
                        dsu.union(root + 3, (root + 4 * N));
                    }
                    if (r - 1 >= 0) {
                        dsu.union(root, (root - 4 * N) + 3);
                    }
                    // east west
                    if (c + 1 < N) {
                        dsu.union(root + 2, (root + 4) + 1);
                    }
                    if (c - 1 >= 0) {
                        dsu.union(root + 1, (root - 4) + 2);
                    }
                }
            }

            return (int) IntStream.range(0, 4 * N * N).filter(x -> dsu.find(x) == x).count();
        }
    }

    class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
            }
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

}
