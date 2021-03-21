package com.leetcode.tag.daily.eight;

/**
 * 73. 矩阵置零
 */
public class SetZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        for (int k = 0; k < n; k++) {
                            matrix[i][k] = 0;
                        }
                        for (int k = 0; k < m; k++) {
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
    }
}
