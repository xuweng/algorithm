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
        int[] visited;

        public List<Integer> eventualSafeNodes(int[][] graph) {
            visited = new int[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (visited[i] == 1) {
                    continue;
                }
                dfs(graph, i);
                if (visited[i] == 2) {
                    result.add(i);
                }
            }

            return result;
        }

        private boolean dfs(int[][] graph, int i) {
            if (visited[i] == 1) {
                return true;
            }
            if (visited[i] == 2) {
                return false;
            }
            visited[i] = 1;
            for (int j : graph[i]) {
                if (dfs(graph, j)) {
                    // 有环直接返回.不回溯.visited不用重置.
                    return true;
                }
            }
            // 访问完成
            visited[i] = 2;
            return false;
        }
    }
}
