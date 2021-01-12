package com.leetcode.tag.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 210. 课程表 II
 * <p>
 * bfs 有环 不会入队
 */
public class FindOrder {
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited;
        int[] result;
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            for (int[] prerequisite : prerequisites) {
                map.computeIfAbsent(prerequisite[1], v -> new ArrayList<>()).add(prerequisite[0]);
            }
            visited = new int[numCourses];
            result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0 && dfs(i)) {
                    return new int[0];
                }
            }

            return result;
        }

        private boolean dfs(int i) {
            if (visited[i] == 1) {
                return true;
            }
            if (visited[i] == 2) {
                return false;
            }
            visited[i] = 1;
            result[index++] = i;
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
