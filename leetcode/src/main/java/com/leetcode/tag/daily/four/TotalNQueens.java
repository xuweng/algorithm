package com.leetcode.tag.daily.four;

/**
 * 52. N皇后 II
 */
public class TotalNQueens {
    class Solution {
        int result;
        boolean[] rows;
        boolean[] cols;
        boolean[] lefts;
        boolean[] rights;

        public int totalNQueens(int n) {
            rows = new boolean[n];
            cols = new boolean[n];
            lefts = new boolean[2 * n];
            rights = new boolean[2 * n];

            dfs(n, 0);
            return result;
        }

        private void dfs(int n, int row) {
            if (row == n) {
                result++;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (rows[row] || cols[i] || lefts[row + i] || rights[n - i + row]) {
                    continue;
                }
                rows[row] = true;
                cols[i] = true;
                //左上为原点
                lefts[row + i] = true;
                //右上为原点
                rights[n - i + row] = true;

                dfs(n, row + 1);

                rows[row] = false;
                cols[i] = false;
                lefts[row + i] = false;
                rights[n - i + row] = false;
            }
        }
    }
}
