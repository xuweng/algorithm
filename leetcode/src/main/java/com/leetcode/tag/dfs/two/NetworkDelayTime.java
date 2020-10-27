package com.leetcode.tag.dfs.two;

import java.util.*;

/**
 * 743. 网络延迟时间
 * <p>
 * 有向图.无向图.
 * <p>
 * 有向图.无向图.
 * <p>
 * 有向图.无向图.
 * <p>
 * 有向图.无向图.
 * <p>
 * 有向图和无向图都有环.
 * <p>
 * 环.环.环.环.
 */
public class NetworkDelayTime {
    class Solution {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        int count;
        int max;
        // visited必须.防止环.
        boolean[] visited;

        public int networkDelayTime(int[][] times, int N, int K) {
            for (int[] time : times) {
                map.computeIfAbsent(time[0], k -> new ArrayList<>()).add(new Integer[]{time[1], time[2]});
            }
            visited = new boolean[N + 1];

            dfs(K, 0);

            return N == count ? max : -1;
        }

        private void dfs(int K, int num) {
            //            if (visited[K]) {
            //                return;
            //            }
            count++;
            visited[K] = true;
            if (!map.containsKey(K)) {
                max = Math.max(max, num);
                return;
            }
            int size = 0;
            for (Integer[] integers : map.get(K)) {
                if (visited[integers[0]]) {
                    size++;
                    continue;
                }
                dfs(integers[0], num + integers[1]);
            }
            if (size == map.get(K).size()) {
                max = Math.max(max, num);
            }
        }
    }

    /**
     * 方法一：深度优先搜索 [Accepted]
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/network-delay-time/solution/wang-luo-yan-chi-shi-jian-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        Map<Integer, Integer> dist;

        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] edge : times) {
                if (!graph.containsKey(edge[0])) {
                    graph.put(edge[0], new ArrayList<>());
                }
                graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
            }
            for (int node : graph.keySet()) {
                graph.get(node).sort(Comparator.comparingInt(a -> a[0]));
            }
            dist = new HashMap<>();
            for (int node = 1; node <= N; ++node) {
                dist.put(node, Integer.MAX_VALUE);
            }

            dfs(graph, K, 0);
            int ans = 0;
            for (int cand : dist.values()) {
                if (cand == Integer.MAX_VALUE) {
                    return -1;
                }
                ans = Math.max(ans, cand);
            }
            return ans;
        }

        public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
            if (elapsed >= dist.get(node)) {
                return;
            }
            dist.put(node, elapsed);
            if (graph.containsKey(node)) {
                for (int[] info : graph.get(node)) {
                    dfs(graph, info[1], elapsed + info[0]);
                }
            }
        }
    }
}
