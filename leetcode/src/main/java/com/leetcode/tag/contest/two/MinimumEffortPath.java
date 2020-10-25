package com.leetcode.tag.contest.two;

/**
 * 5548. 最小体力消耗路径
 */
public class MinimumEffortPath {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;
        int[][] memo;

        public int minimumEffortPath(int[][] heights) {
            visited = new boolean[heights.length][heights[0].length];
            memo = new int[heights.length][heights[0].length];

            dfs(heights, 0, 0);

            int result = Integer.MAX_VALUE;
            for (int[] ints : memo) {
                for (int i : ints) {
                    if (i == 0) {
                        continue;
                    }
                    result = Math.min(result, i);
                }
            }
            return result;
        }

        public int dfs(int[][] heights, int row, int col) {
            if (memo[row][col] != 0) {
                return memo[row][col];
            }
            visited[row][col] = true;
            int result = 0;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c]) {
                    continue;
                }
                int d = dfs(heights, row + rows[i], col + cols[i]);
                result = Math.max(result, Math.abs(d - heights[row][col]));
            }

            memo[row][col] = result;
            return result;
        }
    }
}
