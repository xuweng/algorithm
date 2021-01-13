package com.leetcode.tag.daily.seven;

/**
 * 684. 冗余连接
 */
public class FindRedundantConnection {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            if (edges == null || edges.length == 0) {
                return new int[0];
            }
            UF uf = new UF(edges.length + 1);
            for (int[] edge : edges) {
                if (!uf.union(edge[0], edge[1])) {
                    return new int[]{edge[0], edge[1]};
                }
            }

            return new int[0];
        }
    }

    class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }

        public boolean union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);

            if (iRoot == jRoot) {
                return false;
            }
            parent[iRoot] = jRoot;
            return true;
        }
    }
}
