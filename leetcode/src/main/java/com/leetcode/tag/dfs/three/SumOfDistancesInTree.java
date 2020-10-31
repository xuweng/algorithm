package com.leetcode.tag.dfs.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 834. 树中距离之和
 * <p>
 * 图:环.父结点.相同结点.
 */
public class SumOfDistancesInTree {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree/solution/shu-zhong-ju-chi-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int[] ans;
        // 定义 sz[u] 表示以 u 为根的子树的节点数量
        int[] sz;
        // 定义 dp[u] 表示以 u 为根的子树，它的所有子节点到它的距离之和
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
            // 无向图
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            dfs(0, -1);
            dfs2(0, -1);
            return ans;
        }

        public void dfs(int u, int parent) {
            // 初始化
            sz[u] = 1;
            dp[u] = 0;
            // 向下dfs
            for (int v : graph.get(u)) {
                if (v == parent) {
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
