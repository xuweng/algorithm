package com.leetcode.tag.tree.three;

/**
 * 685. 冗余连接 II
 * <p>
 * 基于无向图，在无向图中判断是否有环，很容易想到可以使用 并查集
 * <p>
 * 基于有向图，在有向图中判断是是否有环，需要使用拓扑排序
 * <p>
 * 拓扑排序中的重要概念 结点的入度 可以帮助我们解决这个问题
 * <p>
 * 有根树的特点：
 * <p>
 * 只有唯一的一个入度为 0 的结点，它是根结点；
 * 不是根结点的其它所有的结点入度为 1；
 * 不可能存在入度为 2 的结点
 */
public class FindRedundantDirectedConnection {
    static class Solution {

        public int[] findRedundantDirectedConnection(int[][] edges) {
            UF uf = new UF(edges.length + 1);

            for (int[] edge : edges) {
                if (!uf.union(edge[0], edge[1])) {
                    return edge;
                }
            }

            return null;
        }
    }

    static class UF {
        int[] parents;

        public UF(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        /**
         * 递归的下一层的入参不改变肯定错
         *
         * @param i
         * @return
         */
        public int find(int i) {
            if (parents[i] != i) {
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return false;
            }
            //i合并到j
            parents[rootI] = rootJ;
            return true;
        }
    }

    /**
     * 方法一：并查集
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/redundant-connection-ii/solution/rong-yu-lian-jie-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int nodesCount = edges.length;
            UnionFind uf = new UnionFind(nodesCount + 1);
            int[] parent = new int[nodesCount + 1];
            for (int i = 1; i <= nodesCount; ++i) {
                parent[i] = i;
            }
            int conflict = -1;
            int cycle = -1;
            for (int i = 0; i < nodesCount; ++i) {
                int[] edge = edges[i];
                int node1 = edge[0], node2 = edge[1];
                if (parent[node2] != node2) {
                    conflict = i;
                } else {
                    parent[node2] = node1;
                    if (uf.find(node1) == uf.find(node2)) {
                        cycle = i;
                    } else {
                        uf.union(node1, node2);
                    }
                }
            }
            if (conflict < 0) {
                int[] redundant = {edges[cycle][0], edges[cycle][1]};
                return redundant;
            } else {
                int[] conflictEdge = edges[conflict];
                if (cycle >= 0) {
                    int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                    return redundant;
                } else {
                    int[] redundant = {conflictEdge[0], conflictEdge[1]};
                    return redundant;
                }
            }
        }
    }

    class UnionFind {
        int[] ancestor;

        public UnionFind(int n) {
            ancestor = new int[n];
            for (int i = 0; i < n; ++i) {
                ancestor[i] = i;
            }
        }

        /**
         * 注意数组下标
         *
         * @param index1
         * @param index2
         */
        public void union(int index1, int index2) {
            ancestor[find(index1)] = find(index2);
        }

        /**
         * 注意入参
         *
         * @param index
         * @return
         */
        public int find(int index) {
            if (ancestor[index] != index) {
                ancestor[index] = find(ancestor[index]);
            }
            return ancestor[index];
        }
    }

    /**
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/redundant-connection-ii/solution/bing-cha-ji-java-by-liweiwei1419/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            // 边的条数（在这个问题里等于结点个数）
            int len = edges.length;
            // 步骤 1：预处理入度数组（记录指向某个结点的边的条数）
            int[] inDegree = new int[len + 1];
            for (int[] edge : edges) {
                inDegree[edge[1]]++;
            }

            // 步骤 2：先尝试删除构成入度为 2 的边，看看是否形成环
            for (int i = len - 1; i >= 0; i--) {
                if (inDegree[edges[i][1]] == 2) {
                    // 如果不构成环，这条边就是要去掉的那条边
                    if (!judgeCircle(edges, len, i)) {
                        return edges[i];
                    }
                }
            }

            // 步骤 3：再尝试删除构成入度为 1 的边，看看是否形成环
            for (int i = len - 1; i >= 0; i--) {
                if (inDegree[edges[i][1]] == 1) {
                    // 如果不构成环，这条边就是要去掉的那条边
                    if (!judgeCircle(edges, len, i)) {
                        return edges[i];
                    }
                }
            }
            throw new IllegalArgumentException("输入不符合要求。");
        }

        /**
         * 将 removeEdgeIndex 去掉以后，剩下的有向边是否构成环
         *
         * @param edges
         * @param len             结点总数（从 1 开始，因此初始化的时候 + 1）
         * @param removeEdgeIndex 删除的边的下标
         * @return 构成环，返回 true
         */
        private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
            UnionFind unionFind = new UnionFind(len + 1);
            for (int i = 0; i < len; i++) {
                if (i == removeEdgeIndex) {
                    continue;
                }
                if (!unionFind.union(edges[i][0], edges[i][1])) {
                    // 合并失败，表示 edges[i][0] 和 edges[i][1] 在一个连通分量里，即构成了环
                    return true;
                }
            }
            return false;
        }

        class UnionFind {
            // 代表元法
            private int[] parent;

            public UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                while (x != parent[x]) {
                    // 路径压缩（隔代压缩）
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            /**
             * 合并是否成功
             *
             * @param x
             * @param y
             * @return 如果合并成功返回 true
             */
            public boolean union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);

                //相等不需要合并
                if (rootX == rootY) {
                    return false;
                }
                //需要合并
                parent[rootX] = rootY;
                return true;
            }
        }
    }

}
