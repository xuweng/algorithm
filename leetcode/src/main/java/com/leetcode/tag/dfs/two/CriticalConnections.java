package com.leetcode.tag.dfs.two;

import java.util.*;

/**
 * 1192. 查找集群内的「关键连接」
 * <p>
 * 哑结点.哑结点.哑结点.哑结点.
 */
public class CriticalConnections {
    /**
     * 作者：tarira19
     * 链接：https://leetcode-cn.com/problems/critical-connections-in-a-network/solution/1192-java-dfstarjansuan-fa-shi-jian-fu-za-du-ove-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        // 构建一个map，存放每个节点的相邻节点有哪些
        Map<Integer, Set<Integer>> map = new HashMap<>();

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            buildMap(connections);
            // 创建一个数组，存放每个节点的id是什么
            int[] id = new int[n];
            Arrays.fill(id, -1);
            // 选取一个点作为根节点，dfs向下递归，过程中识别出哪个边是critical connection
            List<List<Integer>> res = new ArrayList<>();
            // 假设根节点有一个编号是-1父节点
            dfs(0, 0, -1, id, res);

            return res;
        }

        public void buildMap(List<List<Integer>> connections) {
            for (List<Integer> edge : connections) {
                int n1 = edge.get(0);
                int n2 = edge.get(1);

                map.computeIfAbsent(n1, k -> new HashSet<>()).add(n2);
                map.computeIfAbsent(n2, k -> new HashSet<>()).add(n1);
            }
        }

        /**
         * @param node   结点
         * @param nodeID 结点编号
         * @param parent 父结点
         * @param id
         * @param res
         * @return
         */
        public int dfs(int node, int nodeID, int parent, int[] id, List<List<Integer>> res) {
            id[node] = nodeID;

            Set<Integer> set = map.get(node);
            for (Integer neighbor : set) {
                if (neighbor == parent) {
                    continue;
                }
                if (id[neighbor] == -1) {
                    id[node] = Math.min(id[node], dfs(neighbor, nodeID + 1, node, id, res));
                } else {
                    id[node] = Math.min(id[node], id[neighbor]);
                }
            }

            if (id[node] == nodeID && node != 0) {
                res.add(Arrays.asList(parent, node));
            }

            return id[node];
        }
    }
}
