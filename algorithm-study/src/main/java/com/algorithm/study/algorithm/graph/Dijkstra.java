package com.algorithm.study.algorithm.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 是从一个顶点到其余各顶点的最短路径算法，解决的是有权图中最短路径问题。
 */
public class Dijkstra {
    private int n = 5;
    //visit初始为0，防止回溯
    int visit[] = new int[n + 1];

    /**
     * 三色遍历。
     * 白-----》灰----》黑
     * 0------》1-----》2
     * <p>
     * 假设起点为src, 终点为dst, 图以二维矩阵的形式存储，若graph[i][j] == 0, 代表i,j不相连
     *
     * @param src
     * @param dst
     * @param graph
     * @return
     */
    int Dijkstra(int src, int dst, int[][] graph) {
        //优先队列
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        //将起点加入pq
        pq.add(new Node(src, 0));
        visit[src] = 1;
        while (!pq.isEmpty()) {
            //最小距离
            Node t = pq.poll();
            //当前节点是终点，即可返回最短路径
            if (t.node == dst) {
                return t.cost;
            }
            //若当前节点已遍历过，跳过当前节点
            if (visit[t.node] == 2) {
                continue;
            }
            //将当前节点标记成已遍历
            visit[t.node] = 2;
            for (int i = 0; i < n; i++) {
                //graph[t.node][i]存放权值。当前结点的邻接结点。
                if (graph[t.node][i] > 0 && visit[i] == 0) {
                    pq.add(new Node(i, t.cost + graph[t.node][i]));
                    visit[i] = 1;
                }
            }
        }
        return -1;
    }

    /**
     * 学习定义数据结构
     * 学习定义数据结构
     * 定义一个存储节点和离起点相应距离的数据结构
     */
    class Node implements Comparator<Node> {
        //结点标记
        public int node;
        //离起点相应距离
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.cost, node2.cost);
        }
    }
}
