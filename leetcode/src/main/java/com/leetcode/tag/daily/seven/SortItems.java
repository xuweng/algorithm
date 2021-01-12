package com.leetcode.tag.daily.seven;

import java.util.*;

/**
 * 1203. 项目管理
 * <p>
 * 拓扑排序 是对 有向无环图(DAG) 进行排序
 * <p>
 * 判断一个有向图是否存在环
 * <p>
 * bfs Kahn 算法 利用贪心算法，每次先输出入度数为0的顶点，与其依赖的顶点入度数减一，看是否要加入队列，即可。
 * <p>
 * bfs 这种做法不需要使用 visited 数组，因为环的入度不可能为 0，也就不会入队，自然不会有死循环。
 * <p>
 * dfs 使用 DFS 可以从图的任意一点出发，基于深度优先遍历检测是否有环。如果有，则返回 []，如果没有，则直接将 path 返回即可。使用此方法需要 visited 数组。
 */
public class SortItems {
    /**
     * 方法：拓扑排序
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies/solution/1203-xiang-mu-guan-li-by-leetcode-t63b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            // 第 1 步：数据预处理，给没有归属于一个组的项目编上组号
            for (int i = 0; i < group.length; i++) {
                if (group[i] == -1) {
                    group[i] = m;
                    m++;
                }
            }

            // 第 2 步：实例化组和项目的邻接表
            List<Integer>[] groupAdj = new ArrayList[m];
            List<Integer>[] itemAdj = new ArrayList[n];
            for (int i = 0; i < m; i++) {
                groupAdj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                itemAdj[i] = new ArrayList<>();
            }

            // 第 3 步：建图和统计入度数组
            int[] groupsIndegree = new int[m];
            int[] itemsIndegree = new int[n];

            int len = group.length;
            for (int i = 0; i < len; i++) {
                int currentGroup = group[i];
                for (int beforeItem : beforeItems.get(i)) {
                    int beforeGroup = group[beforeItem];
                    if (beforeGroup != currentGroup) {
                        groupAdj[beforeGroup].add(currentGroup);
                        groupsIndegree[currentGroup]++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (Integer item : beforeItems.get(i)) {
                    itemAdj[item].add(i);
                    itemsIndegree[i]++;
                }
            }

            // 第 4 步：得到组和项目的拓扑排序结果
            List<Integer> groupsList = topologicalSort(groupAdj, groupsIndegree, m);
            if (groupsList.size() == 0) {
                return new int[0];
            }
            List<Integer> itemsList = topologicalSort(itemAdj, itemsIndegree, n);
            if (itemsList.size() == 0) {
                return new int[0];
            }

            // 第 5 步：根据项目的拓扑排序结果，项目到组的多对一关系，建立组到项目的一对多关系
            // key：组，value：在同一组的项目列表
            Map<Integer, List<Integer>> groups2Items = new HashMap<>();
            for (Integer item : itemsList) {
                groups2Items.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
            }

            // 第 6 步：把组的拓扑排序结果替换成为项目的拓扑排序结果
            List<Integer> res = new ArrayList<>();
            for (Integer groupId : groupsList) {
                List<Integer> items = groups2Items.getOrDefault(groupId, new ArrayList<>());
                res.addAll(items);
            }
            return res.stream().mapToInt(Integer::valueOf).toArray();
        }

        private List<Integer> topologicalSort(List<Integer>[] adj, int[] inDegree, int n) {
            List<Integer> res = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer front = queue.poll();
                res.add(front);
                for (int successor : adj[front]) {
                    inDegree[successor]--;
                    if (inDegree[successor] == 0) {
                        queue.offer(successor);
                    }
                }
            }

            if (res.size() == n) {
                return res;
            }
            return new ArrayList<>();
        }
    }

}
