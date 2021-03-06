package com.leetcode.tag.backtracking.one;

import java.util.*;

/**
 * 1219. 黄金矿工
 */
public class GetMaximumGold {
  List<List<Integer>> result;
  Deque<Integer> deque;

  public int getMaximumGold(int[][] grid) {
    result = new ArrayList<>();
    deque = new ArrayDeque<>();
    boolean[][] used = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      Arrays.fill(used[i], false);
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          continue;
        }
        backTrack(grid, i, j, used);
      }
    }

    int max = 0;
    for (List<Integer> list : result) {
      max = Math.max(max, list.stream().mapToInt(i -> i).sum());
    }
    return max;
  }

  /**
   * 注意递归终止条件:全部计算完才结束递归。
   *
   * <p>注意结点形成环。造成死循环。造成栈溢出。
   *
   * @param grid
   * @param row
   * @param col
   * @param used
   */
  public void backTrack(int[][] grid, int row, int col, boolean[][] used) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
      result.add(new ArrayList<>(deque));
      return;
    }
    if (used[row][col]) {
      return;
    }

    // 每个格子上下左右4个选择
    used[row][col] = true;
    deque.push(grid[row][col]);
    backTrack(grid, row - 1, col, used);
    deque.pop();
    used[row][col] = false;

    used[row][col] = true;
    deque.push(grid[row][col]);
    backTrack(grid, row + 1, col, used);
    deque.pop();
    used[row][col] = false;

    used[row][col] = true;
    deque.push(grid[row][col]);
    backTrack(grid, row, col - 1, used);
    deque.pop();
    used[row][col] = false;

    used[row][col] = true;
    deque.push(grid[row][col]);
    backTrack(grid, row, col + 1, used);
    deque.pop();
    used[row][col] = false;
  }

  class Solution {
    int max = 0;

    public int getMaximumGold(int[][] grid) {

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] != 0) {
            bt(grid, i, j, 0);
          }
        }
      }
      return max;
    }

    private void bt(int[][] grid, int row, int col, int sum) {
      sum += grid[row][col];
      int tmp = grid[row][col];
      // 有上一行搜索上一行
      if (row - 1 >= 0 && grid[row - 1][col] != 0) {
        grid[row][col] = 0;
        bt(grid, row - 1, col, sum);
        grid[row][col] = tmp;
      }
      // 有下一行搜索下一行
      if (row + 1 < grid.length && grid[row + 1][col] != 0) {
        grid[row][col] = 0;
        bt(grid, row + 1, col, sum);
        grid[row][col] = tmp;
      }
      // 有左一列搜索左一列
      if (col - 1 >= 0 && grid[row][col - 1] != 0) {
        grid[row][col] = 0;
        bt(grid, row, col - 1, sum);
        grid[row][col] = tmp;
      }
      // 有右一列搜索右一列
      if (col + 1 < grid[row].length && grid[row][col + 1] != 0) {
        grid[row][col] = 0;
        bt(grid, row, col + 1, sum);
        grid[row][col] = tmp;
      }
      max = Math.max(max, sum);
    }
  }
}
