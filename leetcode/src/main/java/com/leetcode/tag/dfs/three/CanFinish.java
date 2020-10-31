package com.leetcode.tag.dfs.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. 课程表
 * <p>
 * 图:环.父结点.相同结点.
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
}
