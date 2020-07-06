package com.leetcode.tag.daily;

/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {
  private int count;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null
            || obstacleGrid.length == 0
            || obstacleGrid[0][0] == 1
            || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
      return 0;
    }
    backTrack(obstacleGrid, 0, 0);

    return count;
  }

  public void backTrack(int[][] obstacleGrid, int row, int col) {
    if (row >= obstacleGrid.length || col >= obstacleGrid[0].length) {
      return;
    }
    if (row == obstacleGrid.length - 1
            && col == obstacleGrid[0].length - 1
            && obstacleGrid[row][col] != 1) {
      count++;
      return;
    }
    // 向右
    if (col + 1 < obstacleGrid[0].length && obstacleGrid[row][col + 1] != 1) {
      backTrack(obstacleGrid, row, col + 1);
    }
    // 向下
    if (row + 1 < obstacleGrid.length && obstacleGrid[row + 1][col] != 1) {
      backTrack(obstacleGrid, row + 1, col);
    }
  }
}
