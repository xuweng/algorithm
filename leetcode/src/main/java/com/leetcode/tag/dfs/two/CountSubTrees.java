package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1519. 子树中标签相同的节点数
 * <p>
 * 十分钟.十分钟.十分钟
 * <p>
 * 越来越熟练.越来越熟练.越来越熟练.
 */
public class CountSubTrees {
    /**
     * 算法错误
     */
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result;

        public int[] countSubTrees(int n, int[][] edges, String labels) {
            if (edges == null) {
                return new int[0];
            }
            result = new int[n];
            // 构建无向图
            for (int[] edge : edges) {
                map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            dfs(0, labels, -1);

            return result;
        }

        private int[] dfs(int i, String labels, int parent) {
            int index = labels.charAt(i) - 'a';
            if (!map.containsKey(i)) {
                // 叶子结点
                result[i] = 1;
                int[] ints = new int[26];
                ints[index] = 1;
                return ints;
            }
            int[] a = new int[26];
            for (Integer j : map.get(i)) {
                if (j == parent) {
                    continue;
                }
                int[] ints = dfs(j, labels, i);
                for (int k = 0; k < ints.length; k++) {
                    a[k] += ints[k];
                }
            }
            a[index]++;
            result[i] = a[index];

            return a;
        }

    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/solution/zi-shu-zhong-biao-qian-xiang-tong-de-jie-dian-sh-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] countSubTrees(int n, int[][] edges, String labels) {
            Map<Integer, List<Integer>> edgesMap = new HashMap<>();
            for (int[] edge : edges) {
                int node0 = edge[0], node1 = edge[1];
                List<Integer> list0 = edgesMap.getOrDefault(node0, new ArrayList<>());
                List<Integer> list1 = edgesMap.getOrDefault(node1, new ArrayList<>());
                list0.add(node1);
                list1.add(node0);
                edgesMap.put(node0, list0);
                edgesMap.put(node1, list1);
            }
            int[] counts = new int[n];
            boolean[] visited = new boolean[n];
            depthFirstSearch(0, counts, visited, edgesMap, labels);
            return counts;
        }

        public int[] depthFirstSearch(int node, int[] counts, boolean[] visited, Map<Integer, List<Integer>> edgesMap, String labels) {
            visited[node] = true;
            int[] curCounts = new int[26];
            curCounts[labels.charAt(node) - 'a']++;
            List<Integer> nodesList = edgesMap.get(node);
            for (int nextNode : nodesList) {
                if (!visited[nextNode]) {
                    int[] childCounts = depthFirstSearch(nextNode, counts, visited, edgesMap, labels);
                    for (int i = 0; i < 26; i++) {
                        curCounts[i] += childCounts[i];
                    }
                }
            }
            counts[node] = curCounts[labels.charAt(node) - 'a'];
            return curCounts;
        }
    }

}
