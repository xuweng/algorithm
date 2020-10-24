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
 * dp.用已经计算的推导没有计算的.
 */
public class ContainsCycle {
    /**
     * 方法一：并查集
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
                            return true;
                        }
                    }
                    if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                        if (!uf.findAndUnite(i * n + j, i * n + j - 1)) {
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

}
