package com.jianzi.offer.suaiti;

/**
 * 面试题04. 二维数组中的查找
 */
public class s04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        return recursive(matrix, target, 0, matrix[0].length - 1);
    }

    /**
     * 递归
     *
     * @param matrix
     * @param target
     * @param row    行
     * @param column 列
     * @return
     */
    public boolean recursive(int[][] matrix, int target, int row, int column) {
        if (row >= matrix.length || column < 0) {
            return false;
        }

        if (matrix[row][column] == target) {
            return true;
        } else if (matrix[row][column] > target) {
            return recursive(matrix, target, row, column - 1);
        } else {
            return recursive(matrix, target, row + 1, column);
        }
    }
}
