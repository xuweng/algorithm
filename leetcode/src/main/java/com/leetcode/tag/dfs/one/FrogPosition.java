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
        boolean flag;

        public double frogPosition(int n, int[][] edges, int t, int target) {
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                //graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            visited = new boolean[n + 1];

            dfs(1, t, target, 1);

            return result;
        }

        private void dfs(int i, int t, int target, double result) {
            if (visited[i] || t < 0 || flag) {
                return;
            }
            if (i == target) {
                this.result = result;
                flag = true;
                return;
            }
            visited[i] = true;
            //上面是计算顶点i
            //下面开始计算顶点i的邻接顶点
            if (!graph.containsKey(i)) {
                return;
            }
            List<Integer> list = graph.get(i);
            for (Integer integer : list) {
                dfs(integer, t - 1, target, result * ((double) 1 / list.size()));
            }
        }
    }
}
