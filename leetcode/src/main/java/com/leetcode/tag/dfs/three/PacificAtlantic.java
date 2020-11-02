package com.leetcode.tag.dfs.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * <p>
 * 环.环.环.环.
 * <p>
 * 十分钟.十分钟.十分钟.
 */
public class PacificAtlantic {
    class Solution {
        private int m, n;
        private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        /**
         * 边界判断
         *
         * @param row
         * @param col
         * @return
         */
        private boolean inArea(int row, int col) {
            return 0 <= row && row < m && 0 <= col && col < n;
        }

        private void dfs(int[][] matrix, int row, int col, int[][] tmp) {
            tmp[row][col] = 1;
            for (int[] d : direction) {
                int r = row + d[0];
                int c = col + d[1];
                // 剪枝
                if (!inArea(r, c) || matrix[row][col] > matrix[r][c] || tmp[r][c] == 1) {
                    continue;
                }
                dfs(matrix, r, c, tmp);
            }
        }

        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> ans = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return ans;
            }
            m = matrix.length;
            n = matrix[0].length;
            int[][] po = new int[m][n], ao = new int[m][n]; //po 太平洋，ao 大西洋
            for (int i = 0; i < n; ++i) {
                // 0行 太平洋
                dfs(matrix, 0, i, po);
                // 最后一行 大西洋
                dfs(matrix, m - 1, i, ao);
            }
            for (int i = 0; i < m; ++i) {
                // 0列 太平洋
                dfs(matrix, i, 0, po);
                // 最后一列 大西洋
                dfs(matrix, i, n - 1, ao);
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (po[i][j] == 1 && ao[i][j] == 1) {
                        ans.add(Arrays.asList(i, j));
                    }
                }
            }
            return ans;
        }
    }
}
