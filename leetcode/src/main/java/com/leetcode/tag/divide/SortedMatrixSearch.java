package com.leetcode.tag.divide;

/**
 * 划分2份?
 *
 * <p>划分4份?
 *
 * <p>2份,4份麻烦
 *
 * <p>面试题 10.09. 排序矩阵查找
 */
public class SortedMatrixSearch {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    return divide(matrix, 0, matrix[0].length - 1, target);
  }

  public boolean divide(int[][] matrix, int i, int j, int target) {
    if (i >= matrix.length || j < 0) {
      return false;
    }

    if (matrix[i][j] == target) {
      return true;
    } else if (matrix[i][j] > target) {
      return divide(matrix, i, j - 1, target);
    } else {
      return divide(matrix, i + 1, j, target);
    }
  }
}
