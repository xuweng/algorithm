package com.leetcode.tag.dfs.three;

import java.util.*;

/**
 * 207. 课程表
 * <p>
 * 图:环.父结点.相同结点.
 * <p>
 * 拓扑排序.有向无环图.
 */
public class CanFinish {
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null || prerequisites.length == 0) {
                return true;
            }
            for (int[] prerequisite : prerequisites) {
                map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            }
            visited = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 2) {
                    continue;
                }
                if (dfs(i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int i) {
            if (visited[i] == 1) {
                return true;
            }
            if (visited[i] == 2) {
                return false;
            }
            visited[i] = 1;
            if (map.containsKey(i)) {
                for (Integer j : map.get(i)) {
                    if (dfs(j)) {
                        return true;
                    }
                }
            }
            visited[i] = 2;
            return false;
        }
    }

    /**
     * 方法二: 广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        List<List<Integer>> edges;
        int[] indeg;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            indeg = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            // 队列保存入度为0的结点
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            int visited = 0;
            while (!queue.isEmpty()) {
                ++visited;
                int u = queue.poll();
                for (int v : edges.get(u)) {
                    // 邻接顶点入度减1
                    --indeg[v];
                    if (indeg[v] == 0) {
                        // 入度为0入队
                        queue.offer(v);
                    }
                }
            }

            return visited == numCourses;
        }
    }

}
