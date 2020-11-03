package com.leetcode.tag.dfs.three;

/**
 * 面试题 08.10. 颜色填充
 */
public class FloodFill {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image[sr][sc] == newColor) {
                return image;
            }

            dfs(image, sr, sc, newColor, image[sr][sc]);

            return image;
        }

        private void dfs(int[][] image, int row, int col, int newColor, int old) {
            if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != old) {
                return;
            }
            image[row][col] = newColor;
            for (int i = 0; i < rows.length; i++) {
                dfs(image, row + rows[i], col + cols[i], newColor, old);
            }
        }
    }
}
