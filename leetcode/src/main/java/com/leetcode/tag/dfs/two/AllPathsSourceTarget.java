package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
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

        private void dfs(int i, int[][] graph, LinkedList<Integer> stack) {
            stack.addLast(i);
            if (graph[i].length == 0) {
                // 叶子结点
                result.add(new LinkedList<>(stack));
            } else {
                for (Integer j : graph[i]) {
                    dfs(j, graph, stack);
                }
            }
            stack.removeLast();
        }
    }
}
