package com.leetcode.tag.dfs.three;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 947. 移除最多的同行或同列石头
 * <p>
 * 搞懂题意.搞懂题意.搞懂题意.
 */
public class RemoveStones {
    /**
     * 方法一： 深度优先搜索
     * <p>
     * 在这里我们用深度优先搜索来计算图中的连通分量的个数，通过深度优先搜索遍历连通分量中的每个节点。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/solution/yi-chu-zui-duo-de-tong-xing-huo-tong-lie-shi-tou-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int removeStones(int[][] stones) {
            int n = stones.length;

            // graph[i][0] = the length of the 'list' graph[i][1:]
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        graph[i][++graph[i][0]] = j;
                        graph[j][++graph[j][0]] = i;
                    }
                }
            }

            int ans = 0;
            boolean[] seen = new boolean[n];
            for (int i = 0; i < n; ++i) {
                if (!seen[i]) {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(i);
                    seen[i] = true;
                    ans--;
                    while (!stack.isEmpty()) {
                        int node = stack.pop();
                        ans++;
                        for (int k = 1; k <= graph[node][0]; ++k) {
                            int nei = graph[node][k];
                            if (!seen[nei]) {
                                stack.push(nei);
                                seen[nei] = true;
                            }
                        }
                    }
                }
            }

            return ans;
        }
    }

    /**
     * 方法二： 并查集
     */
    class Solution1 {
        public int removeStones(int[][] stones) {
            DSU dsu = new DSU(20000);

            // 对于一个坐标为 (i, j) 的石子来说，需要把行 i 和列 j 合并，因为并查集是一维的，用 j+10000 来代替 j
            for (int[] stone : stones) {
                dsu.union(stone[0], stone[1] + 10000);
            }

            Set<Integer> seen = new HashSet<>();
            for (int[] stone : stones) {
                // 保存顶点的root
                seen.add(dsu.find(stone[0]));
            }

            return stones.length - seen.size();
        }
    }

    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        /**
         * 查询root
         *
         * @param x
         * @return
         */
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

}
