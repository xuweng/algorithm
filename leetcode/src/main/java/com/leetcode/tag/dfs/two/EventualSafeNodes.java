package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 802. 找到最终的安全状态
 * <p>
 * 十分钟。十分钟。十分钟
 * <p>
 * 拓扑排序。拓扑排序。拓扑排序。拓扑排序.
 */
public class EventualSafeNodes {
    class Solution {
        List<Integer> result = new ArrayList<>();
        boolean[] visited;

        public List<Integer> eventualSafeNodes(int[][] graph) {
            visited = new boolean[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (graph[i].length == 0) {
                    result.add(i);
                    continue;
                }
                dfs(graph, i);
            }

            Collections.sort(result);
            return result;
        }

        private int dfs(int[][] graph, int i) {
            if (visited[i]) {
                return 10000;
            }
            visited[i] = true;
            if (graph[i].length == 0) {
                // 回溯时机
                visited[i] = false;
                return 0;
            }
            int r = 10000;
            for (int j : graph[i]) {
                r = Math.min(r, dfs(graph, j)) + 1;
            }
            if (r <= i) {
                result.add(i);
            }
            // visited[i] = false;
            return r;
        }
    }
}
