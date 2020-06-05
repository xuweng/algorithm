package com.leetcode.tag.daily;

/**
 * 面试题29. 顺时针打印矩阵
 */
public class SpiralOrder {
  public int[] spiralOrder(int[][] matrix) {
    return null;
  }

  /**
   * 方法一：模拟 可以模拟打印矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，
   *
   * <p>当路径超出界限或者进入之前访问过的位置时，则顺时针旋转，进入下一个方向。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/shun-shi-zhen-da-yin-ju-zhen-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int[] spiralOrder(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return new int[0];
      }
      int rows = matrix.length, columns = matrix[0].length;
      boolean[][] visited = new boolean[rows][columns];

      int total = rows * columns;
      int[] result = new int[total];

      int row = 0, column = 0;
      int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int directionIndex = 0;
      for (int i = 0; i < total; i++) {
        result[i] = matrix[row][column];
        visited[row][column] = true;
        int nextRow = row + directions[directionIndex][0],
                nextColumn = column + directions[directionIndex][1];
        if (nextRow < 0
                || nextRow >= rows
                || nextColumn < 0
                || nextColumn >= columns
                || visited[nextRow][nextColumn]) {
          directionIndex = (directionIndex + 1) % 4;
        }
        row += directions[directionIndex][0];
        column += directions[directionIndex][1];
      }
      return result;
    }
  }
}
