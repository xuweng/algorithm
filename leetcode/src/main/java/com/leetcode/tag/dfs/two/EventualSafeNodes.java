package com.leetcode.tag.dfs.two;

import java.util.*;

/**
 * 802. 找到最终的安全状态
 * <p>
 * 十分钟。十分钟。十分钟
 * <p>
 * 拓扑排序。拓扑排序。拓扑排序。拓扑排序.
 */
public class EventualSafeNodes {
    /**
     * 区分环和访问完成的结点
     * <p>
     * 环是一种状态
     * <p>
     * 访问完成是一种状态
     */
    class Solution {
        List<Integer> result = new ArrayList<>();
        int[] visited;

        public List<Integer> eventualSafeNodes(int[][] graph) {
            visited = new int[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (visited[i] == 1) {
                    // 有环
                    continue;
                }
                if (visited[i] == 0) {
                    dfs(graph, i);
                }
                if (visited[i] == 2) {
                    // 访问完成
                    result.add(i);
                }
            }

            return result;
        }

        private boolean dfs(int[][] graph, int i) {
            if (visited[i] == 1) {
                // 有环
                return true;
            }
            if (visited[i] == 2) {
                // 此条件必须
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

    /**
     * 对于一个节点 u，如果我们从 u 开始任意行走能够走到一个环里，那么 u 就不是一个安全的节点
     * <p>
     * 方法一：拓扑排序
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states/solution/zhao-dao-zui-zhong-de-an-quan-zhuang-tai-by-leetco/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<Integer> eventualSafeNodes(int[][] G) {
            int N = G.length;
            boolean[] safe = new boolean[N];

            List<Set<Integer>> graph = new ArrayList<>();
            List<Set<Integer>> rgraph = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                graph.add(new HashSet<>());
                rgraph.add(new HashSet<>());
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < N; ++i) {
                if (G[i].length == 0) {
                    queue.offer(i);
                }
                for (int j : G[i]) {
                    graph.get(i).add(j);
                    rgraph.get(j).add(i);
                }
            }

            while (!queue.isEmpty()) {
                int j = queue.poll();
                safe[j] = true;
                for (int i : rgraph.get(j)) {
                    graph.get(i).remove(j);
                    if (graph.get(i).isEmpty()) {
                        queue.offer(i);
                    }
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                if (safe[i]) {
                    ans.add(i);
                }
            }

            return ans;
        }
    }

}
