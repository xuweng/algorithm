package com.leetcode.tag.daily;

/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {
  private int count;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    boolean[][] used = new boolean[obstacleGrid.length][obstacleGrid[0].length];
    backTrack(obstacleGrid, used, 0, 0);

    return count;
  }

  public void backTrack(int[][] obstacleGrid, boolean[][] used, int row, int col) {
    if (row >= obstacleGrid.length || col >= obstacleGrid[0].length) {
      return;
    }
    if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
      count++;
      return;
    }
    // 向右
    if (col + 1 < obstacleGrid[0].length
            && !used[row][col + 1]
            && obstacleGrid[row][col + 1] != 1) {
      used[row][col + 1] = true;
      backTrack(obstacleGrid, used, row, col + 1);
      used[row][col + 1] = false;
    }
    // 向下
    if (row + 1 < obstacleGrid.length && !used[row + 1][col] && obstacleGrid[row + 1][col] != 1) {
      used[row + 1][col] = true;
      backTrack(obstacleGrid, used, row + 1, col);
      used[row + 1][col] = false;
    }
  }
}
