package com.leetcode.tag.dfs.one;

/**
 * 547. 朋友圈
 */
public class FindCircleNum {
    class Solution {
        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};
        boolean[][] used;

        public int findCircleNum(int[][] M) {
            used = new boolean[M.length][M[0].length];
            int result = 0;
            for (int i = 0; i < M.length; i++) {
                for (int i1 = 0; i1 < M[0].length; i1++) {
                    if (M[i][i1] == 1 && !used[i][i1]) {
                        result++;
                        dfs(M, i, i1);
                    }
                }
            }

            return result;
        }

        private void dfs(int[][] M, int row, int col) {
            if (row < 0 || row >= M.length || col < 0 || col >= M[0].length || M[row][col] == 0 || used[row][col]) {
                return;
            }
            used[row][col] = true;
            for (int i = 0; i < r.length; i++) {
                dfs(M, row + r[i], col + c[i]);
            }
        }
    }
}
