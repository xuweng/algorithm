package com.leetcode.tag.tree.two;

import java.util.*;

/**
 * 1443. 收集树上所有苹果的最少时间
 */
public class MinTime {
    static class Solution {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            Map<Integer, List<Integer>> map = new HashMap<>(64);
            for (int[] edge : edges) {
                List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
                list.add(edge[1]);
                map.put(edge[0], list);
            }

            int result = back(0, map, hasApple);

            return (result > 0) ? result * 2 : 0;
        }

        /**
         * 后序遍历
         *
         * @param root
         * @param map
         * @param hasApple
         * @return
         */
        private int back(int root, Map<Integer, List<Integer>> map, List<Boolean> hasApple) {
            List<Integer> list = map.get(root);
            //通过不同返回值区分
            if (hasApple.get(root)) {
                return 0;
            }
            //叶子结点
            if (list == null) {
                return -1;
            }
            int result = 0;
            for (Integer integer : list) {
                int i = back(integer, map, hasApple);
                if (i >= 0) {
                    //累加
                    result += i + 1;
                }
            }

            return result;
        }
    }

    /**
     * 作者：geguanting
     * 链接：https://leetcode-cn.com/problems/minimum-time-to-collect-all-apples-in-a-tree/solution/dfsshen-ru-qian-chu-by-geguanting/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public void buildReverseEdges(List<List<Integer>> nodeMap, int val) {
            for (int pairVal : nodeMap.get(val)) {
                if (pairVal != 0 && reverseEdges[pairVal] == -1) {
                    reverseEdges[pairVal] = val;
                    buildReverseEdges(nodeMap, pairVal);
                }
            }
        }

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            List<List<Integer>> nodeMap = new ArrayList<>(n);
            //初始化
            for (int i = 0; i < n; i++) {
                nodeMap.add(new ArrayList<>());
            }
            //保存结点的所有相邻结点
            for (int[] edge : edges) {
                //from-------->to
                nodeMap.get(edge[0]).add(edge[1]);
                //to---------->from
                nodeMap.get(edge[1]).add(edge[0]);
            }

            reverseEdges = new int[n];
            Arrays.fill(reverseEdges, -1);

            buildReverseEdges(nodeMap, 0);

            visited = new boolean[n];
            visited[0] = true;

            for (int i = 0; i < n; i++) {
                if (hasApple.get(i)) {
                    dfsEdge(i);
                }
            }
            return ans * 2;
        }

        int ans = 0;
        //两个点.from-------->to改为to---------->from
        int[] reverseEdges;
        boolean[] visited;

        public void dfsEdge(int to) {
            if (!visited[to]) {
                visited[to] = true;
                ans++;
                dfsEdge(reverseEdges[to]);
            }
        }
    }

}
