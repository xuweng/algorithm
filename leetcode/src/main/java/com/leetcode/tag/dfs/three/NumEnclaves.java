package com.leetcode.tag.dfs.three;

/**
 * 1020. 飞地的数量
 * <p>
 * 学到什么东西.学到什么东西.学到什么东西.学到什么东西.
 * <p>
 * 有向图.无向图.环.缓存.
 * <p>
 * 状态:未dfs.dfs中.已经dfs.
 */
public class NumEnclaves {
    class Solution {
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        boolean flag = false;

        public int numEnclaves(int[][] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 1) {
                        int d = dfs(A, i, j);
                        result = flag ? result : result + d;
                        flag = false;
                    }
                }
            }
            return result;
        }

        private int dfs(int[][] A, int row, int col) {
            if (A[row][col] == 0) {
                return 0;
            }
            A[row][col] = 2;
            int result = 1;
            for (int i = 0; i < rows.length; i++) {
                int r = row + rows[i];
                int c = col + cols[i];
                if (r < 0 || r >= A.length || c < 0 || c >= A[0].length) {
                    flag = true;
                    continue;
                }
                if (A[r][c] == 1) {
                    result += dfs(A, r, c);
                }
            }
            return result;
        }
    }

    /**
     * 作者：TheWayshower
     * 链接：https://leetcode-cn.com/problems/number-of-enclaves/solution/java-xian-ba-suo-you-he-bian-jie-xiang-jie-de-lu-d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int row, col;
        int[][] A;

        public int numEnclaves(int[][] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            this.A = A;
            this.row = A.length;
            this.col = A[0].length;

            // 淹没所有和边界相接的陆地
            for (int i = 0; i < row; i++) {
                // 第1列
                dfs(i, 0);
                // 最后1列
                dfs(i, col - 1);
            }
            for (int i = 0; i < col; i++) {
                // 第1行
                dfs(0, i);
                // 最后1行
                dfs(row - 1, i);
            }
            // 统计剩下的飞陆
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (A[i][j] == 1) {
                        count++;
                    }
                }
            }
            return count;
        }

        /**
         * 把此大陆淹没，即把 1 变成 0
         *
         * @param r,c DFS 起点
         */
        public void dfs(int r, int c) {
            if (A[r][c] == 0) {
                return;
            }

            A[r][c] = 0;
            if (r > 0) {
                dfs(r - 1, c);
            }
            if (c > 0) {
                dfs(r, c - 1);
            }
            if (r < row - 1) {
                dfs(r + 1, c);
            }
            if (c < col - 1) {
                dfs(r, c + 1);
            }
        }
    }

}
