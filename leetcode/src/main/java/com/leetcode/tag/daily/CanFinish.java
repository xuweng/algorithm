package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 * <p>
 * 拓扑排序
 */
public class CanFinish {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            return true;
        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        List<List<Integer>> edges;
        int[] visited;
        boolean valid = true;

        /**
         * 记住三色搜索。三种颜色。三种状态。重点在回溯。
         * <p>
         * 算法
         * <p>
         * 对于图中的任意一个节点，它在搜索的过程中有三种状态，即：
         * <p>
         * 「未搜索」：我们还没有搜索到这个节点；
         * <p>
         * 「搜索中」：我们搜索过这个节点，但还没有回溯到该节点，即该节点还没有入栈，还有相邻的节点没有搜索完成）；
         * <p>
         * 「已完成」：我们搜索过并且回溯过这个节点，即该节点已经入栈，并且所有该节点的相邻节点都出现在栈的更底部的位置，满足拓扑排序的要求。
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;
        }

        public void dfs(int u) {
            visited[u] = 1;
            for (int v : edges.get(u)) {
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;
        }
    }

}
