package com.leetcode.tag.dfs.one;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 */
public class UpdateMatrix {
    static class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean[][] used;
        int result = Integer.MAX_VALUE;

        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0][0];
            }
            used = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < matrix[0].length; i1++) {
                    if (matrix[i][i1] == 1) {
                        dfs(matrix, i, i1, 0);
                        matrix[i][i1] = result;
                        result = Integer.MAX_VALUE;
                    }
                }
            }
            return matrix;
        }

        private void dfs(int[][] matrix, int row, int col, int count) {
            if (count > result) {
                return;
            }
            if (matrix[row][col] == 0) {
                result = count;
                return;
            }
            used[row][col] = true;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || used[r][c]) {
                    continue;
                }
                dfs(matrix, r, c, count + 1);
            }
            used[row][col] = false;
        }
    }

    /**
     * 方法一：广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dist = new int[m][n];
            boolean[][] seen = new boolean[m][n];
            //保存坐标
            Queue<int[]> queue = new LinkedList<>();
            // 将所有的 0 添加进初始队列中
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        seen[i][j] = true;
                    }
                }
            }

            // 广度优先搜索
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int i = cell[0], j = cell[1];
                //上下左右
                for (int d = 0; d < 4; ++d) {
                    int ni = i + dirs[d][0];
                    int nj = j + dirs[d][1];
                    //边界检查、是否访问
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                        //计算
                        dist[ni][nj] = dist[i][j] + 1;
                        queue.offer(new int[]{ni, nj});
                        seen[ni][nj] = true;
                    }
                }
            }

            return dist;
        }
    }

}
