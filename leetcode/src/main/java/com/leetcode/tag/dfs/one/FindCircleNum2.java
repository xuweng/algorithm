package com.leetcode.tag.dfs.one;

/**
 * 547. 朋友圈
 */
public class FindCircleNum2 {
    class Solution {
        boolean[] visited;

        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0) {
                return 0;
            }
            int result = 0;
            visited = new boolean[M.length];
            for (int i = 0; i < M.length; i++) {
                if (visited[i]) {
                    continue;
                }
                dfs(M, i);
                result++;
            }

            return result;
        }

        private void dfs(int[][] M, int i) {
            visited[i] = true;
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 0 || visited[j]) {
                    continue;
                }
                dfs(M, j);
            }
        }
    }
}
