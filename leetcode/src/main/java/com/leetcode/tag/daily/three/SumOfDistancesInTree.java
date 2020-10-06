package com.leetcode.tag.daily.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 834. 树中距离之和
 */
public class SumOfDistancesInTree {
    /**
     * 超出时间限制
     */
    static class Solution {
        //map表示无向图
        Map<Integer, List<Integer>> graph;
        boolean[] used;
        int count;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            int[] result = new int[N];
            if (edges == null || edges.length == 0) {
                result[0] = 0;
                return result;
            }
            graph = new HashMap<>(N);
            used = new boolean[N];
            //构建无向图
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            for (int i = 0; i < N; i++) {
                dfs(i, 0);
                result[i] = count;
                count = 0;
            }
            return result;
        }

        private void dfs(int i, int j) {
            count += j;
            //哪里选择哪里标记
            //选择顶点i
            //在这里标记
            //顶点i和邻接顶点没有重合
            used[i] = true;

            //顶点i的邻接顶点dfs
            List<Integer> list = graph.get(i);
            if (list != null && !list.isEmpty()) {
                for (Integer integer : list) {
                    if (used[integer]) {
                        continue;
                    }
                    dfs(integer, j + 1);
                }
            }

            used[i] = false;
        }
    }

    /**
     * 方法一：树形动态规划
     * <p>
     * 每个结点都为root
     * <p>
     * 考虑一个节点的情况，即每次题目指定一棵树，以 root 为根，询问节点 root 与其他所有节点的距离之和
     * <p>
     * 求出每个节点为根节点的时候，它与其他所有节点的距离之和。暴力的角度我们可以考虑对每个节点都做一次如上的树形动态规划，这样时间复杂度即为 O(N^2)
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree/solution/shu-zhong-ju-chi-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[] ans;
        //定义sz[u] 表示以 u 为根的子树的节点数量
        int[] sz;
        //定义dp[u] 表示以 u 为根的子树，它的所有子节点到它的距离之和
        int[] dp;
        List<List<Integer>> graph;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            ans = new int[N];
            sz = new int[N];
            dp = new int[N];
            graph = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            dfs(0, -1);
            dfs2(0, -1);
            return ans;
        }

        /**
         * 看示例理解代码
         * <p>
         * 看图理解代码
         *
         * @param u
         * @param f
         */
        public void dfs(int u, int f) {
            sz[u] = 1;
            dp[u] = 0;
            for (int v : graph.get(u)) {
                if (v == f) {
                    continue;
                }
                dfs(v, u);
                dp[u] += dp[v] + sz[v];
                sz[u] += sz[v];
            }
        }

        public void dfs2(int u, int f) {
            ans[u] = dp[u];
            for (int v : graph.get(u)) {
                if (v == f) {
                    continue;
                }
                int pu = dp[u], pv = dp[v];
                int su = sz[u], sv = sz[v];

                dp[u] -= dp[v] + sz[v];
                sz[u] -= sz[v];
                dp[v] += dp[u] + sz[u];
                sz[v] += sz[u];

                dfs2(v, u);

                dp[u] = pu;
                dp[v] = pv;
                sz[u] = su;
                sz[v] = sv;
            }
        }
    }

}
