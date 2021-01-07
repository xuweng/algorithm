package com.leetcode.tag.daily.seven;

/**
 * 547. 省份数量
 */
public class FindCircleNum {
    class Solution {
        boolean[] visited;

        public int findCircleNum(int[][] isConnected) {
            if (isConnected == null || isConnected.length == 0) {
                return 0;
            }
            visited = new boolean[isConnected.length];
            int result = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (visited[i]) {
                    continue;
                }
                dfs(isConnected, i);

                result++;
            }

            return result;
        }

        private void dfs(int[][] isConnected, int i) {
            visited[i] = true;
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 0 || visited[j]) {
                    continue;
                }
                dfs(isConnected, j);
            }
        }
    }
}
