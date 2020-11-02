package com.leetcode.tag.dfs.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. 课程表
 */
public class CanFinish2 {
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null || prerequisites.length == 0) {
                return true;
            }
            visited = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0 && dfs(i)) {
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
                for (Integer integer : map.get(i)) {
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
