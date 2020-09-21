package com.leetcode.tag.tree.three;

/**
 * 685. 冗余连接 II
 */
public class FindRedundantDirectedConnection {
    class Solution {

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

    class UF {
        int[] parents;

        public UF(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int i) {
            if (parents[i] != i) {
                parents[i] = find(i);
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
            parents[i] = rootJ;
            return true;
        }
    }
}
