package com.leetcode.tag.daily.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 834. 树中距离之和
 */
public class SumOfDistancesInTree {
    static class Solution {
        Map<Integer, List<Integer>> graph;
        Map<Integer, Integer> parent;
        boolean[] used;
        int count;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            if (edges == null || edges.length == 0) {
                return new int[0];
            }
            graph = new HashMap<>(N);
            parent = new HashMap<>(N);
            used = new boolean[N];
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                parent.put(edge[1], edge[0]);
            }
            int[] result = new int[N];
            for (int i = 0; i < N; i++) {
                dfs(i, 0);
                result[i] = count;
                count = 0;
            }
            return result;
        }

        private void dfs(int i, int j) {
            count += j;
            //选择顶点i
            used[i] = true;

            List<Integer> list = graph.get(i);
            if (list != null && !list.isEmpty()) {
                for (int i1 = 0; i1 < list.size(); i1++) {
                    if (used[i1]) {
                        continue;
                    }
                    dfs(i1, j + 1);
                }
            }
            Integer p = parent.get(i);
            if (p != null && !used[p]) {
                dfs(p, j + 1);
            }

            used[i] = false;
        }
    }
}
