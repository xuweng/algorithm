package com.leetcode.tag.dfs.one;

import java.util.*;

/**
 * 1377. T 秒后青蛙的位置
 */
public class FrogPosition {
    class Solution {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited;
        double result;
        boolean flag;

        public double frogPosition(int n, int[][] edges, int t, int target) {
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            visited = new boolean[n + 1];

            dfs(1, t, target, 1);

            return result;
        }

        private void dfs(int i, int t, int target, double result) {
            if (visited[i] || t < 0 || flag) {
                return;
            }
            if (i == target) {
                this.result = result;
                flag = true;
                return;
            }
            visited[i] = true;
            //上面是计算顶点i
            //下面开始计算顶点i的邻接顶点
            if (!graph.containsKey(i)) {
                return;
            }
            List<Integer> list = graph.get(i);
            int size = (int) list.stream().filter(integer -> !visited[integer]).count();
            for (Integer integer : list) {
                dfs(integer, t - 1, target, result * ((double) 1 / size));
            }
        }
    }

    /**
     * BFS
     * <p>
     * 作者：Joseph1314
     * 链接：https://leetcode-cn.com/problems/frog-position-after-t-seconds/solution/bfs-zhe-ge-qing-wa-shi-si-xin-yan-by-joseph1314/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        //自定义数据结构
        class Node {
            //顶点
            int id;
            //概率
            double p;
            //时间
            int t;

            Node(int i, double pp, int tt) {
                id = i;
                p = pp;
                t = tt;
            }
        }

        public double frogPosition(int n, int[][] edges, int t, int target) {
            Set<Integer>[] graph = new Set[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new HashSet<>();
            }
            //构建无向图
            for (int[] e : edges) {
                graph[e[0]].add(e[1]);
                graph[e[1]].add(e[0]);
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(1, 1.000000, 0));
            boolean[] visited = new boolean[n + 1];
            visited[1] = true;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.t == t && node.id == target) {
                    //找到target
                    return node.p;
                }
                if (node.t >= t) {
                    continue;
                }
                int size = (int) graph[node.id].stream().mapToInt(nb -> nb).filter(nb -> !visited[nb]).count();
                boolean find = false;
                //邻接顶点
                for (int nb : graph[node.id]) {
                    if (visited[nb]) {
                        continue;
                    }
                    find = true;
                    visited[nb] = true;
                    queue.offer(new Node(nb, node.p / size, node.t + 1));
                }
                if (!find) {
                    queue.offer(new Node(node.id, node.p, node.t + 1));
                }

            }
            return 0.0;

        }
    }

    /**
     * dfs
     * <p>
     * 作者：wu-bin-cong
     * 链接：https://leetcode-cn.com/problems/frog-position-after-t-seconds/solution/da-jia-du-yong-bfswo-lai-ge-dfsban-ben-xiang-xi-ji/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        //表示跳到每个节点的概率,初始值pr[1] = 1.0
        double[] p = new double[105];
        //dfs过程会使用到，用于记录该节点有没有被遍历过。
        boolean[] visited = new boolean[105];
        Map<Integer, List<Integer>> graph = new HashMap<>(); //记录边的连接信息

        void dfs(int cur, int t) {
            //如果时间到了，那就退出
            if (t <= 0) {
                return;
            }
            int toCount = (int) graph.get(cur).stream().mapToInt(next -> next).filter(next -> !visited[next]).count();
            //首先观察青蛙能去的地方
            //如果已经没有地方能去了，那就退出
            if (toCount == 0) {
                return;
            }
            //跳往每个地方都是均匀分布的，概率均匀
            double p = this.p[cur] / toCount;
            for (int next : graph.get(cur)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                this.p[cur] -= p;
                //开始跳之前，将概率转移
                this.p[next] += p;
                //这样青蛙就可以安心跳过去了
                dfs(next, t - 1);
                visited[next] = false;
            }
        }

        /**
         * 1 <= n <= 100
         * <p>
         * 1 <= t <= 50
         *
         * @param n
         * @param edges
         * @param t
         * @param target
         * @return
         */
        public double frogPosition(int n, int[][] edges, int t, int target) {
            //题目的数据量很小，才100个节点，本来担心暴力dfs模拟的话会不会超时。
            //但是青蛙不会走回头路，这样就可以去掉很多很多的情况，对于dfs来说，应该不会超时的，然后开始干！
            //初始化。
            for (int i = 0; i < n; i++) {
                p[i] = 0;
                visited[i] = false;
            }
            //因为是无向图
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            //初始化表示在当前1节点。
            p[1] = 1;
            visited[1] = true;
            dfs(1, t);
            return p[target];
        }
    }
}
