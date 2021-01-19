package com.leetcode.tag.daily.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 * <p>
 * 看图理解 不能太扣细节 算法思想最重要
 * <p>
 * 最小生成树 并查集
 * <p>
 * 最小生成树
 * <p>
 * 任意两点之间有且仅有一条简单路径只有树，且这棵树包含 n 个节点。我们称这棵树为给定的图的生成树，其中总权值最小的生成树，我们称其为最小生成树。
 */
public class MinCostConnectPoints {
    /**
     * 方法一：Kruskal 算法
     * <p>
     * 该算法的基本思想是从小到大加入边，是一个贪心算法。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points/solution/lian-jie-suo-you-dian-de-zui-xiao-fei-yo-kcx7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            DisjointSetUnion dsu = new DisjointSetUnion(n);
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    edges.add(new Edge(dist(points, i, j), i, j));
                }
            }
            //将图 G={V,E} 中的所有边按照长度由小到大进行排序，等长的边可以按任意顺序
            edges.sort(Comparator.comparingInt(edge -> edge.len));
            int ret = 0, num = 1;
            for (Edge edge : edges) {
                int len = edge.len, x = edge.x, y = edge.y;
                if (dsu.unionSet(x, y)) {
                    // 只有没有连接过的顶点才能连接
                    // 连接成功 计算
                    ret += len;
                    num++;
                    if (num == n) {
                        break;
                    }
                }
            }
            return ret;
        }

        public int dist(int[][] points, int x, int y) {
            return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
        }
    }

    /**
     * 使用并查集维护连通性
     */
    class DisjointSetUnion {
        int[] f;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            this.f = new int[n];
            for (int i = 0; i < n; i++) {
                this.f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public boolean unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return false;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
            return true;
        }
    }

    class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

}
