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

  /**
   * 直接得到行数组
   *
   * <p>不能直接得到列数组
   *
   * @param matrix
   * @param target
   * @return
   */
  public boolean searchMatrix1(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    // 最大对角
    int duiJiao = Math.min(matrix.length, matrix[0].length);
    for (int i = 0; i < duiJiao; i++) {
    }

    return false;
  }

  private boolean binarySearch(int[] array, int low, int high, int target) {
    if (low > high) {
      return false;
    }
    int mid = low + (high - low) / 2;
    if (array[mid] == target) {
      return true;
    } else if (array[mid] < target) {
      return binarySearch(array, mid + 1, high, target);
    } else {
      return binarySearch(array, low, mid - 1, target);
    }
  }

  /**
   * 方法一：暴力法
   */
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
          if (matrix[i][j] == target) {
            return true;
          }
        }
      }

      return false;
    }
  }

  /**
   * 方法二：二分法搜索
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * 在对角线上迭代，二分搜索行和列，直到对角线的迭代元素用完为止
     *
     * @param matrix
     * @param target
     * @param start
     * @param vertical
     * @return
     */
    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
      int lo = start;
      int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;

      while (hi >= lo) {
        int mid = (lo + hi) >> 1;
        if (vertical) { // searching a column
          if (matrix[start][mid] < target) {
            lo = mid + 1;
          } else if (matrix[start][mid] > target) {
            hi = mid - 1;
          } else {
            return true;
          }
        } else { // searching a row
          if (matrix[mid][start] < target) {
            lo = mid + 1;
          } else if (matrix[mid][start] > target) {
            hi = mid - 1;
          } else {
            return true;
          }
        }
      }

      return false;
    }

    /**
     * 迭代对角线
     *
     * <p>理解迭代对角线
     *
     * <p>关键理解迭代对角线
     *
     * <p>关键理解迭代对角线
     *
     * <p>关键理解迭代对角线
     *
     * <p>关键理解迭代对角线
     *
     * <p>如果我们迭代矩阵对角线，从当前元素对列和行搜索，我们可以保持从当前 (row,col) 对开始的行和列为已排序
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
      // an empty matrix obviously does not contain `target`
      if (matrix == null || matrix.length == 0) {
        return false;
      }

      // iterate over matrix diagonals
      int shorterDim = Math.min(matrix.length, matrix[0].length);
      for (int i = 0; i < shorterDim; i++) {
        boolean verticalFound = binarySearch(matrix, target, i, true);
        boolean horizontalFound = binarySearch(matrix, target, i, false);
        if (verticalFound || horizontalFound) {
          return true;
        }
      }

      return false;
    }
  }
}
