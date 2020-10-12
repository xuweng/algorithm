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
                //graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
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
            for (Integer integer : list) {
                dfs(integer, t - 1, target, result * ((double) 1 / list.size()));
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

}
