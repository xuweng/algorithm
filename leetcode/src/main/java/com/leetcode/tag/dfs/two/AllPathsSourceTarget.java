package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * <p>
 * 所有从 0 到 n-1 的路径
 * <p>
 * 搞懂题意.搞懂题意.搞懂题意.
 */
public class AllPathsSourceTarget {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            if (graph == null || graph.length == 0) {
                return result;
            }
            dfs(0, graph, new LinkedList<>());

            return result;
        }

        private void dfs(int start, int[][] graph, LinkedList<Integer> stack) {
            stack.addLast(start);
            if (start == graph.length - 1) {
                result.add(new LinkedList<>(stack));
            } else {
                for (Integer j : graph[start]) {
                    dfs(j, graph, stack);
                }
            }
            stack.removeLast();
        }
    }
}
