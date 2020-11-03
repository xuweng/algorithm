package com.leetcode.tag.dfs.three;

/**
 * 面试题 08.10. 颜色填充
 */
public class FloodFill {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] visited;

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            visited = new boolean[image.length][image[0].length];

            dfs(image, sr, sc, newColor, image[sr][sc]);

            return image;
        }

        private void dfs(int[][] image, int row, int col, int newColor, int old) {
            if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != old || visited[row][col]) {
                return;
            }
            visited[row][col] = true;
            image[row][col] = newColor;
            for (int i = 0; i < rows.length; i++) {
                dfs(image, row + rows[i], col + cols[i], newColor, old);
            }
        }
    }
}
