package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 210. 课程表 II
 * <p>
 * dfs
 * <p>
 * 并查集.并查集.并查集.每个root.每个连通分量.
 * <p>
 * 本题是一道经典的「拓扑排序」问题。
 * <p>
 * 3种状态.拓扑排序.环.
 */
public class FindOrder {
    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        // 存储有向图
        List<List<Integer>> edges;
        // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
        int[] visited;
        // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
        int[] result;
        // 判断有向图中是否有环
        boolean valid = true;
        // 栈下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            result = new int[numCourses];
            index = numCourses - 1;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
            for (int i = 0; i < numCourses && valid; ++i) {
                //未搜索
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            if (!valid) {
                return new int[0];
            }
            // 如果没有环，那么就有拓扑排序
            // 在整个深度优先搜索的过程结束后，如果我们没有找到图中的环，那么栈中存储这所有的 n 个节点，从栈顶到栈底的顺序即为一种拓扑排序。
            return result;
        }

        /**
         * 节点有3种状态
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
         * 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param u
         */
        public void dfs(int u) {
            // 开始
            // 将节点标记为「搜索中」
            visited[u] = 1;
            // 进行dfs

            // 搜索其相邻节点
            // 只要发现有环，立刻停止搜索
            for (int v : edges.get(u)) {
                // 如果「未搜索」那么搜索相邻节点
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                }
                // 如果「搜索中」说明找到了环
                // 因此是不存在拓扑排序的
                else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            // 回溯
            // 将节点标记为「已完成」
            visited[u] = 2;
            // 将节点入栈
            result[index--] = u;
        }
    }

    class Solution1 {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited;
        int[] result;
        int index;
        boolean flag = true;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            index = numCourses - 1;
            visited = new int[numCourses];
            result = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            }

            for (int i = 0; i < numCourses && flag; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            if (!flag) {
                return new int[0];
            }

            return result;
        }

        private void dfs(int i) {
            visited[i] = 1;
            if (map.containsKey(i)) {
                for (Integer integer : map.get(i)) {
                    if (visited[integer] == 0) {
                        dfs(integer);
                        //这里return效率会提高.
                        if (!flag) {
                            return;
                        }
                    } else if (visited[integer] == 1) {
                        // 有环
                        flag = false;
                        return;
                    }
                }
            }
            visited[i] = 2;
            result[index--] = i;
        }
    }

}
