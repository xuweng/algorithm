package com.leetcode.tag.daily.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 */
public class MinCostConnectPoints {
    /**
     * 方法一：Kruskal}Kruskal 算法
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
            List<Edge> edges = new ArrayList<Edge>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    edges.add(new Edge(dist(points, i, j), i, j));
                }
            }
            Collections.sort(edges, (edge1, edge2) -> edge1.len - edge2.len);
            int ret = 0, num = 1;
            for (Edge edge : edges) {
                int len = edge.len, x = edge.x, y = edge.y;
                if (dsu.unionSet(x, y)) {
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
