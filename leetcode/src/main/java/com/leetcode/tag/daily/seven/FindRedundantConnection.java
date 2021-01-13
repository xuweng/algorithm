package com.leetcode.tag.daily.seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    static class Solution1 {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited;
        int[] result;

        public int[] findRedundantConnection(int[][] edges) {
            if (edges == null || edges.length == 0) {
                return new int[0];
            }
            visited = new int[edges.length + 1];
            result = new int[2];
            for (int[] edge : edges) {
                map.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
                map.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
            }
            for (int i = 1; i <= edges.length; i++) {
                if (visited[i] == 0 && dfs(-1, i)) {
                    return result;
                }
            }

            return result;
        }

        private boolean dfs(int parent, int i) {
            if (visited[i] == 1) {
                result[0] = parent;
                result[1] = i;
                return true;
            }
            if (visited[i] == 2) {
                return false;
            }
            visited[i] = 1;
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                for (Integer integer : list) {
                    if (i == integer) {
                        continue;
                    }
                    if (dfs(i, integer)) {
                        return true;
                    }
                }
            }
            visited[i] = 2;
            return false;
        }
    }
}
