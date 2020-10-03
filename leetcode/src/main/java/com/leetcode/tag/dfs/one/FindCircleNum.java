package com.leetcode.tag.dfs.one;

/**
 * 547. 朋友圈.
 * <p>
 * 搞懂题意.
 * <p>
 * 无向图.搞懂题意.
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
                        int count = dfs(M, i, i1);
                        if (count > 1) {
                            result++;
                        }
                    }
                }
            }

            return result;
        }

        private int dfs(int[][] M, int row, int col) {
            if (row < 0 || row >= M.length || col < 0 || col >= M[0].length || M[row][col] == 0 || used[row][col]) {
                return 0;
            }
            used[row][col] = true;
            int count = 1;
            for (int i = 0; i < r.length; i++) {
                count += dfs(M, row + r[i], col + c[i]);
            }
            return count;
        }
    }
}
