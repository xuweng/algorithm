package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1377. T 秒后青蛙的位置
 */
public class FrogPosition {
    class Solution {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited;
        double result;

        public double frogPosition(int n, int[][] edges, int t, int target) {
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            visited = new boolean[n + 1];

            dfs(1, t, target, 1);

            return result;
        }

        private void dfs(int i, int t, int target, double result) {
            if (visited[i] || !graph.containsKey(i) || t < 0) {
                return;
            }
            if (i == target) {
                this.result = result;
                return;
            }
            visited[i] = true;
            List<Integer> list = graph.get(i);
            for (Integer integer : list) {
                dfs(integer, t - 1, target, result * ((double) 1 / list.size()));
            }
        }
    }
}
