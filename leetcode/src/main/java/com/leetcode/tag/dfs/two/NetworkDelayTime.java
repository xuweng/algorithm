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
                    // 只要有一个无法广播就return
                    return -1;
                }
                ans = Math.max(ans, cand);
            }
            return ans;
        }

        public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
            if (elapsed >= dist.get(node)) {
                // 遇到环会退出
                // 遇到长路径会退出
                return;
            }
            // dist[node] 记录的是信号最早到达 node 的时间
            // 短路径会覆盖
            dist.put(node, elapsed);
            if (!graph.containsKey(node)) {
                return;
            }
            for (int[] info : graph.get(node)) {
                dfs(graph, info[1], elapsed + info[0]);
            }
        }
    }

    /**
     * 方法二：迪杰斯特拉最短路径算法（Dijkstra's）[Accepted]
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/network-delay-time/solution/wang-luo-yan-chi-shi-jian-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        Map<Integer, Integer> dist;

        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] edge : times) {
                if (!graph.containsKey(edge[0])) {
                    graph.put(edge[0], new ArrayList<>());
                }
                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            }
            dist = new HashMap<>();
            for (int node = 1; node <= N; ++node) {
                dist.put(node, Integer.MAX_VALUE);
            }

            dist.put(K, 0);
            boolean[] seen = new boolean[N + 1];

            // Dijkstra's 算法是每次扩展一个距离最短的点，更新与其相邻点的距离。
            while (true) {
                int candNode = -1;
                int candDist = Integer.MAX_VALUE;
                for (int i = 1; i <= N; ++i) {
                    if (!seen[i] && dist.get(i) < candDist) {
                        candDist = dist.get(i);
                        candNode = i;
                    }
                }

                if (candNode < 0) {
                    break;
                }
                seen[candNode] = true;
                if (graph.containsKey(candNode)) {
                    for (int[] info : graph.get(candNode)) {
                        // 保留最短路径
                        dist.put(info[0],
                                Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
                    }
                }
            }

            int ans = 0;
            for (int cand : dist.values()) {
                if (cand == Integer.MAX_VALUE) {
                    return -1;
                }
                ans = Math.max(ans, cand);
            }
            return ans;
        }
    }

    /**
     * 堆实现
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/network-delay-time/solution/wang-luo-yan-chi-shi-jian-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] edge : times) {
                if (!graph.containsKey(edge[0])) {
                    graph.put(edge[0], new ArrayList<>());
                }
                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            }
            PriorityQueue<int[]> heap = new PriorityQueue<>(
                    Comparator.comparingInt(info -> info[0]));
            heap.offer(new int[]{0, K});

            // 保留最短路径
            Map<Integer, Integer> dist = new HashMap<>();

            while (!heap.isEmpty()) {
                // 每次取最小结点
                int[] info = heap.poll();
                int d = info[0], node = info[1];
                if (dist.containsKey(node)) {
                    continue;
                }
                dist.put(node, d);
                // node的邻接结点
                if (graph.containsKey(node)) {
                    for (int[] edge : graph.get(node)) {
                        int nei = edge[0], d2 = edge[1];
                        if (!dist.containsKey(nei)) {
                            // 邻接顶点入堆
                            heap.offer(new int[]{d + d2, nei});
                        }
                    }
                }
            }

            if (dist.size() != N) {
                return -1;
            }
            int ans = 0;
            for (int cand : dist.values()) {
                ans = Math.max(ans, cand);
            }
            return ans;
        }

    }
}
