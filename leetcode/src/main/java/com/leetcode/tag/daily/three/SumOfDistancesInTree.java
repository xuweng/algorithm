package com.leetcode.tag.daily.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 834. 树中距离之和
 */
public class SumOfDistancesInTree {
    /**
     * 超出时间限制
     */
    static class Solution {
        //map表示无向图
        Map<Integer, List<Integer>> graph;
        boolean[] used;
        int count;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            int[] result = new int[N];
            if (edges == null || edges.length == 0) {
                result[0] = 0;
                return result;
            }
            graph = new HashMap<>(N);
            used = new boolean[N];
            //构建无向图
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            for (int i = 0; i < N; i++) {
                dfs(i, 0);
                result[i] = count;
                count = 0;
            }
            return result;
        }

        private void dfs(int i, int j) {
            count += j;
            //哪里选择哪里标记
            //选择顶点i
            //在这里标记
            //顶点i和邻接顶点没有重合
            used[i] = true;

            //顶点i的邻接顶点dfs
            List<Integer> list = graph.get(i);
            if (list != null && !list.isEmpty()) {
                for (Integer integer : list) {
                    if (used[integer]) {
                        continue;
                    }
                    dfs(integer, j + 1);
                }
            }

            used[i] = false;
        }
    }
}
