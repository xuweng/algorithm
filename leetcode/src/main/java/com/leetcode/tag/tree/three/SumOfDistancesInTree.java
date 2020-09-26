package com.leetcode.tag.tree.three;

import java.util.*;

/**
 * 834. 树中距离之和
 */
public class SumOfDistancesInTree {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree/solution/shu-zhong-ju-chi-zhi-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int[] ans, count;
        //下标表示结点.set表示所有边.
        List<Set<Integer>> graph;
        int N;

        /**
         * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans
         * <p>
         * 父->子和子->父.
         *
         * @param N
         * @param edges
         * @return
         */
        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            this.N = N;
            graph = new ArrayList<>();
            ans = new int[N];
            count = new int[N];
            Arrays.fill(count, 1);

            //构造结点
            for (int i = 0; i < N; ++i) {
                graph.add(new HashSet<>());
            }
            //构造边.
            for (int[] edge : edges) {
                //无向图.有向图.
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            dfs(0, -1);
            dfs2(0, -1);
            //表示节点 i 与其他所有节点距离之和的列表
            return ans;
        }

        public void dfs(int node, int parent) {
            for (int child : graph.get(node)) {
                if (child != parent) {
                    dfs(child, node);
                    count[node] += count[child];
                    ans[node] += ans[child] + count[child];
                }
            }
        }

        public void dfs2(int node, int parent) {
            for (int child : graph.get(node)) {
                if (child != parent) {
                    ans[child] = ans[node] - count[child] + N - count[child];
                    dfs2(child, node);
                }
            }
        }
    }
}
