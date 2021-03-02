package com.leetcode.tag.daily.eight;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}
