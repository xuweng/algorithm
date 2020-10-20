package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
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
                if (visited[i]) {
                    continue;
                }
                dfs(graph, i);
                if (!visited[i]) {
                    result.add(i);
                }
            }

            return result;
        }

        private boolean dfs(int[][] graph, int i) {
            if (visited[i]) {
                return true;
            }
            visited[i] = true;
            for (int j : graph[i]) {
                if (dfs(graph, j)) {
                    return true;
                } else {
                    visited[j] = false;
                }
            }
            // visited[i] = false;
            return false;
        }
    }
}
