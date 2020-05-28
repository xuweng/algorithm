package com.leetcode.tag.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1219. 黄金矿工
 */
public class GetMaximumGold {
  List<List<Integer>> result;
  Deque<Integer> deque;

  public int getMaximumGold(int[][] grid) {
    result = new ArrayList<>();
    deque = new ArrayDeque<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          continue;
        }
        backTrack(grid, i, j);
      }
    }

    int max = 0;
    for (List<Integer> list : result) {
      max = Math.max(max, list.stream().mapToInt(i -> i).sum());
    }
    return max;
  }

  public void backTrack(int[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return;
    }
    if (grid[row][col] == 0) {
      return;
    }
    // 错误。等于边界还需要继续计算。
    if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
      result.add(new ArrayList<>(deque));
      return;
    }

    // 每个格子上下左右4个选择
    deque.push(grid[row][col]);
    backTrack(grid, row - 1, col);
    deque.pop();

    deque.push(grid[row][col]);
    backTrack(grid, row + 1, col);
    deque.pop();

    deque.push(grid[row][col]);
    backTrack(grid, row, col - 1);
    deque.pop();

    deque.push(grid[row][col]);
    backTrack(grid, row, col + 1);
    deque.pop();
  }
}
