package com.leetcode.tag.daily.four;

import java.util.*;

/**
 * 743. 网络延迟时间
 * <p>
 * 递归终止条件
 * <p>
 * 递归终止条件
 */
public class NetworkDelayTime {
    class Solution {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] dist;

        public int networkDelayTime(int[][] times, int N, int K) {
            if (times == null || times.length == 0) {
                return 0;
            }
            for (int[] time : times) {
                map.computeIfAbsent(time[0], k -> new ArrayList<>()).add(new int[]{time[1], time[2]});
            }
            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dfs(K, 0);

            int result = 0;
            for (int j = 1, distLength = dist.length; j < distLength; j++) {
                if (dist[j] == Integer.MAX_VALUE) {
                    return -1;
                }
                result = Math.max(result, dist[j]);
            }
            return result;
        }

        private void dfs(int i, int dis) {
            if (dis >= dist[i]) {
                // 关键
                // 遇到环或者长路径
                return;
            }
            dist[i] = dis;
            if (!map.containsKey(i)) {
                return;
            }
            for (int[] ints : map.get(i)) {
                dfs(ints[0], dis + ints[1]);
            }
        }
    }
}
