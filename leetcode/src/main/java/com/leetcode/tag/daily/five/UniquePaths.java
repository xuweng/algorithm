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

            back(0, 0);
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

}
