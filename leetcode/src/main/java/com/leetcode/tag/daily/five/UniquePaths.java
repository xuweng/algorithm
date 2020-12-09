package com.leetcode.tag.daily.five;

/**
 * 62. 不同路径
 */
public class UniquePaths {
    static class Solution {
        int result;

        int m;
        int n;

        public int uniquePaths(int m, int n) {
            this.m = m;
            this.n = n;

            back(1, 1);
            return result;
        }

        public void back(int row, int col) {
            if (row == m && col == n) {
                result++;
                return;
            }
            if (row < m) {
                back(row + 1, col);
            }
            if (col < n) {
                back(row, col + 1);
            }
        }
    }

    class Solution1 {
        int m;
        int n;
        int[][] meno;

        public int uniquePaths(int m, int n) {
            this.m = m;
            this.n = n;
            meno = new int[m + 1][n + 1];

            return back(1, 1);
        }

        private int back(int row, int col) {
            if (row > m || col > n) {
                return 0;
            }
            if (row == m && col == n) {
                return 1;
            }
            if (meno[row][col] != 0) {
                return meno[row][col];
            }
            int result = back(row + 1, col) + back(row, col + 1);
            meno[row][col] = result;
            return result;
        }
    }

    class Solution2 {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                dp[m - 1][i] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[i][n - 1] = 1;
            }
            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }

            return dp[0][0];
        }
    }

}
