package com.leetcode.tag.divide;

/**
 * 240. 搜索二维矩阵 II
 */
public class SearchMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    return divide(matrix, 0, matrix[0].length - 1, target);
  }

  public boolean divide(int[][] matrix, int row, int col, int target) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
      return false;
    }
    if (matrix[row][col] == target) {
      return true;
    } else if (matrix[row][col] < target) {
      return divide(matrix, row + 1, col, target);
    } else {
      return divide(matrix, row, col - 1, target);
    }
  }
}
