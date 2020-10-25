package com.leetcode.tag.contest.two;

/**
 * 5548. 最小体力消耗路径
 */
public class MinimumEffortPath {
    /**
     * 超出时间限制
     */
    static class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;
        int result = Integer.MAX_VALUE;

        public int minimumEffortPath(int[][] heights) {
            visited = new boolean[heights.length][heights[0].length];

            dfs(heights, 0, 0, heights.length - 1, heights[0].length - 1, 0);

            return result;
        }

        public void dfs(int[][] heights, int row, int col, int endR, int endC, int cha) {
            if (row == endR && col == endC) {
                result = Math.min(result, cha);
                return;
            }
            visited[row][col] = true;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c]) {
                    continue;
                }
                dfs(heights, r, c, endR, endC, Math.max(cha, Math.abs(heights[r][c] - heights[row][col])));
            }
            visited[row][col] = false;

        }
    }

    class Solution1 {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;
        int[][] meno;
        int result = Integer.MAX_VALUE;

        public int minimumEffortPath(int[][] heights) {
            visited = new boolean[heights.length][heights[0].length];
            meno = new int[heights.length][heights[0].length];

            dfs(heights, 0, 0, heights.length - 1, heights[0].length - 1);

            return result;
        }

        public int dfs(int[][] heights, int row, int col, int endR, int endC) {
            if (meno[row][col] != 0) {
                return meno[row][col];
            }
            if (row == endR && col == endC) {
                return heights[row][col];
            }
            visited[row][col] = true;
            int re = 0;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c]) {
                    continue;
                }

                re = Math.max(re, Math.max(dfs(heights, r, c, endR, endC), Math.abs(heights[r][c] - heights[row][col])));
            }
            visited[row][col] = false;
            meno[row][col] = re;
            return re;
        }
    }
}
