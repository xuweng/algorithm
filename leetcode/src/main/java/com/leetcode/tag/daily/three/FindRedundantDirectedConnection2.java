package com.leetcode.tag.daily.three;

/**
 * 685. 冗余连接 II
 * <p>
 * 直接看答案
 * <p>
 * 直接看答案
 * <p>
 * 直接看答案
 */
public class FindRedundantDirectedConnection2 {
    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            return null;
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

        /**
         * 下标初始化
         * <p>
         * 每个结点都是root
         *
         * @param n
         */
        public UnionFind(int n) {
            ancestor = new int[n];
            for (int i = 0; i < n; ++i) {
                ancestor[i] = i;
            }
        }

        /**
         * index1合并到index2
         * <p>
         * index1的root改为index2的root
         *
         * @param index1
         * @param index2
         */
        public void union(int index1, int index2) {
            ancestor[find(index1)] = find(index2);
        }

        /**
         * 查询index的root
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

}
