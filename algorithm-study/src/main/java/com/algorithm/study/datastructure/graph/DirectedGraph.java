package com.algorithm.study.datastructure.graph;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 有向无环图（DAG）
 * <p>
 * 图形的顶点可以表示要执行的任务，并且边可以表示一个任务必须在另一个任务之前执行的约束；
 * 在这个应用中，拓扑排序只是一个有效的任务顺序。
 * <p>
 * 拓扑排序，其实就是寻找一个入度为0的顶点，该顶点是拓扑排序中的第一个顶点序列，将之标记删除，
 * 然后将与该顶点相邻接的顶点的入度减1，再继续寻找入度为0的顶点，直至所有的顶点都已经标记删除或者图中有环。
 * 用来实现拓扑排序的有向无环图
 */
public class DirectedGraph {

    private class Vertex {
        private String vertexLabel;// 顶点标识
        private List<Edge> adjEdges;
        private int inDegree;// 该顶点的入度

        public Vertex(String verTtexLabel) {
            this.vertexLabel = verTtexLabel;
            inDegree = 0;
            adjEdges = new LinkedList<Edge>();
        }
    }

    private class Edge {
        private Vertex endVertex;

        // private double weight;
        public Edge(Vertex endVertex) {
            this.endVertex = endVertex;
        }
    }

    private Map<String, Vertex> directedGraph;

    public DirectedGraph(String graphContent) {
        directedGraph = new LinkedHashMap<String, DirectedGraph.Vertex>();
        buildGraph(graphContent);
    }

    private void buildGraph(String graphContent) {
        String[] lines = graphContent.split("\n");
        Vertex startNode, endNode;
        String startNodeLabel, endNodeLabel;
        Edge e;
        for (int i = 0; i < lines.length; i++) {
            String[] nodesInfo = lines[i].split(",");
            startNodeLabel = nodesInfo[1];
            endNodeLabel = nodesInfo[2];
            startNode = directedGraph.get(startNodeLabel);
            if (startNode == null) {
                startNode = new Vertex(startNodeLabel);
                directedGraph.put(startNodeLabel, startNode);
            }
            endNode = directedGraph.get(endNodeLabel);
            if (endNode == null) {
                endNode = new Vertex(endNodeLabel);
                directedGraph.put(endNodeLabel, endNode);
            }

            e = new Edge(endNode);//每读入一行代表一条边
            startNode.adjEdges.add(e);//每读入一行数据,起始顶点添加一条边
            endNode.inDegree++;//每读入一行数据,终止顶点入度加1
        }
    }

    public void topoSort() throws Exception {
        int count = 0;

        Queue<Vertex> queue = new LinkedList<>();// 拓扑排序中用到的栈,也可用队列.
        //扫描所有的顶点,将入度为0的顶点入队列
        Collection<Vertex> vertexs = directedGraph.values();
        for (Vertex vertex : vertexs)
            if (vertex.inDegree == 0)
                queue.offer(vertex);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.print(v.vertexLabel + " ");
            count++;
            for (Edge e : v.adjEdges)
                if (--e.endVertex.inDegree == 0)
                    queue.offer(e.endVertex);
        }
        if (count != directedGraph.size())
            throw new Exception("Graph has circle");
    }
}
