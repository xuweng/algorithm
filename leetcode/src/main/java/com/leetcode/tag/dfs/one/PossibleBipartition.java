package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 886. 可能的二分法
 * <p>
 * 排列:重复是正确的.
 * <p>
 * 排序去重.厉害.排序厉害.排序厉害.
 * <p>
 * 简洁代码.简洁代码.简洁代码.
 * <p>
 * 图.邻接矩阵.邻接表.
 * <p>
 * 想到图.想到图.想到图.
 * <p>
 * 环.判断图是否有环.并查集.
 */
public class PossibleBipartition {
    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            if (dislikes == null || dislikes.length == 0) {
                return true;
            }
            UF uf = new UF(N + 1);
            for (int[] dislike : dislikes) {
                if (!uf.union(dislike[0], dislike[1])) {
                    return false;
                }
            }

            return true;
        }
    }

    class UF {
        int[] parents;

        public UF(int n) {
            this.parents = new int[n];

            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public int find(int i) {
            if (parents[i] != i) {
                parents[i] = find(parents[i]);
            }

            return parents[i];
        }

        public boolean union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) {
                return false;
            }
            parents[iRoot] = jRoot;
            return true;
        }
    }

    /**
     * 方法：深度优先搜索
     * <p>
     * 对于每个连通的部分，我们只需试着用两种颜色对它进行着色，就可以检查它是否是二分的
     * <p>
     * 如何做到这一点：将任一结点涂成红色，然后将它的所有邻居都涂成蓝色，然后将所有的邻居的邻居都涂成红色，以此类推
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/possible-bipartition/solution/ke-neng-de-er-fen-fa-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        //图存储方式是邻接矩阵和邻接表
        //邻接表
        //用map来表示图的邻接表
        Map<Integer, List<Integer>> graph;
        Map<Integer, Integer> color;

        public boolean possibleBipartition(int N, int[][] dislikes) {
            graph = new HashMap<>(N + 1);
            //无向图构建
            //用map来表示无向图的邻接表
            for (int[] edge : dislikes) {
                graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
            }

            color = new HashMap<>();
            //图从顶点开始dfs
            for (int node = 1; node <= N; ++node) {
                if (!color.containsKey(node) && !dfs(node, 0)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 软色:0-1-0-1-0...
         *
         * @param node
         * @param c
         * @return
         */
        public boolean dfs(int node, int c) {
            if (color.containsKey(node)) {
                return color.get(node) == c;
            }
            color.put(node, c);

            for (int nei : graph.get(node)) {
                if (!dfs(nei, c ^ 1)) {
                    return false;
                }
            }
            return true;
        }
    }

}
