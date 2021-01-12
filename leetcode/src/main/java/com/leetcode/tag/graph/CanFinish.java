package com.leetcode.tag.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. 课程表
 */
public class CanFinish {
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            for (int[] prerequisite : prerequisites) {
                map.computeIfAbsent(prerequisite[0], v -> new ArrayList<>()).add(prerequisite[1]);
            }

            visited = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0 && dfs(i)) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 是否有环
         *
         * @param i
         * @return
         */
        private boolean dfs(int i) {
            if (visited[i] == 1) {
                return true;
            }
            visited[i] = 1;
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                for (Integer integer : list) {
                    if (dfs(integer)) {
                        return true;
                    }
                }
            }
            visited[i] = 2;
            return false;
        }
    }
}
