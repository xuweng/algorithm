package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 743. 网络延迟时间
 * <p>
 * 有向图.无向图.
 * <p>
 * 有向图.无向图.
 * <p>
 * 有向图.无向图.
 * <p>
 * 有向图.无向图.
 * <p>
 * 有向图和无向图都有环.
 */
public class NetworkDelayTime {
    class Solution {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        int count;
        int max;
        boolean[] visited;

        public int networkDelayTime(int[][] times, int N, int K) {
            for (int[] time : times) {
                map.computeIfAbsent(time[0], k -> new ArrayList<>()).add(new Integer[]{time[1], time[2]});
            }
            visited = new boolean[N + 1];

            dfs(K, 0);

            return N == count ? max : -1;
        }

        private void dfs(int K, int num) {
            if (visited[K]) {
                return;
            }
            count++;
            visited[K] = true;
            if (!map.containsKey(K)) {
                max = Math.max(max, num);
                return;
            }
            for (Integer[] integers : map.get(K)) {
                dfs(integers[0], num + integers[1]);
            }
        }
    }
}
