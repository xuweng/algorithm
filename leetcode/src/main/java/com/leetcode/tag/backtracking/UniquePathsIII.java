package com.leetcode.tag.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 980. 不同路径 III
 */
public class UniquePathsIII {
  private int count;
  private int zeroCount;
  private int endRow;
  private int endCol;

  // 保存路径,便于分析
  private Deque<Integer[]> deque;

  public int uniquePathsIII(int[][] grid) {
    int row = 0;
    int col = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          zeroCount++;
        }

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
    boolean[][] used = new boolean[grid.length][grid[0].length];

    deque = new ArrayDeque<>();

    backTrack(grid, 0, used, row, col);

    return count;
  }

  /**
   * 每一个无障碍方格都要通过一次
   *
   * <p>算法框架
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
  public void backTrack(int[][] grid, int backCount, boolean[][] used, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return;
    }
    if (row == endRow && col == endCol) {
      if (zeroCount == backCount - 1) {
        count++;
      }
      return;
    }
    if (row >= 1 && !used[row][col] && grid[row - 1][col] != -1) {
      used[row][col] = true;
      deque.push(new Integer[]{row, col});

      backTrack(grid, backCount + 1, used, row - 1, col);

      used[row][col] = false;
      deque.pop();
    }
    if (row < grid.length - 1 && !used[row][col] && grid[row + 1][col] != -1) {
      used[row][col] = true;
      deque.push(new Integer[]{row, col});

      backTrack(grid, backCount + 1, used, row + 1, col);

      used[row][col] = false;
      deque.pop();
    }
    if (col >= 1 && !used[row][col] && grid[row][col - 1] != -1) {
      used[row][col] = true;
      deque.push(new Integer[]{row, col});

      backTrack(grid, backCount + 1, used, row, col - 1);

      used[row][col] = false;
      deque.pop();
    }
    if (col < grid[0].length - 1 && !used[row][col] && grid[row][col + 1] != -1) {
      used[row][col] = true;
      deque.push(new Integer[]{row, col});

      backTrack(grid, backCount + 1, used, row, col + 1);

      used[row][col] = false;
      deque.pop();
    }
  }
}
