package com.leetcode.tag.daily.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1319. 连通网络的操作次数
 */
public class MakeConnected {
    /**
     * 方法一：深度优先搜索
     * <p>
     * 可以使用深度优先搜索来得到图中的连通分量数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/solution/lian-tong-wang-luo-de-cao-zuo-ci-shu-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        List<Integer>[] edges;
        boolean[] used;

        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }

            edges = new List[n];
            for (int i = 0; i < n; ++i) {
                edges[i] = new ArrayList<>();
            }
            // 无向图
            for (int[] conn : connections) {
                edges[conn[0]].add(conn[1]);
                edges[conn[1]].add(conn[0]);
            }

            used = new boolean[n];
            // 连通分量个数
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                if (used[i]) {
                    continue;
                }
                dfs(i);
                ++ans;
            }

            return ans - 1;
        }

        public void dfs(int u) {
            used[u] = true;
            for (int v : edges[u]) {
                if (!used[v]) {
                    dfs(v);
                }
            }
        }
    }

    /**
     * 方法二：并查集
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/solution/lian-tong-wang-luo-de-cao-zuo-ci-shu-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }

            UnionFind uf = new UnionFind(n);
            for (int[] conn : connections) {
                uf.unite(conn[0], conn[1]);
            }

            return uf.setCount - 1;
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

}
