package com.leetcode.tag.backtracking;

/**
 * 980. 不同路径 III
 */
public class UniquePathsIII {
  int count;
  int endRow;
  int endCol;

  public int uniquePathsIII(int[][] grid) {
    boolean[][] used = new boolean[grid.length][grid[0].length];
    int row = 0;
    int col = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          row = i;
          col = j;
        }
        if (grid[i][j] == 2) {
          endRow = i;
          endCol = j;
        }
      }
    }

    backTrack(grid, used, row, col);
    return 0;
  }

  /**
   * 算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * @param grid
   * @param used
   * @param row
   * @param col
   * @return
   */
  public void backTrack(int[][] grid, boolean[][] used, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return;
    }
    if (row == endRow && col == endCol) {
      count++;
      return;
    }
    if (row >= 1 && !used[row][col] && grid[row - 1][col] == 0) {
      used[row][col] = true;
      backTrack(grid, used, row - 1, col);
      used[row][col] = false;
    }
    if (row < grid.length - 1 && !used[row][col] && grid[row + 1][col] == 0) {
      used[row][col] = true;
      backTrack(grid, used, row + 1, col);
      used[row][col] = false;
    }
    if (col >= 1 && !used[row][col] && grid[row][col - 1] == 0) {
      used[row][col] = true;
      backTrack(grid, used, row, col - 1);
      used[row][col] = false;
    }
    if (col < grid[0].length - 1 && !used[row][col] && grid[row][col + 1] == 0) {
      used[row][col] = true;
      backTrack(grid, used, row, col + 1);
      used[row][col] = false;
    }
  }
}
