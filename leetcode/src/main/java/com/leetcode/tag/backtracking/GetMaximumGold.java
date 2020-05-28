package com.leetcode.tag.backtracking;

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

    boolean[][] used = new boolean[grid.length][grid.length];
    for (int i = 0; i < grid.length; i++) {
      Arrays.fill(used[i], false);
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        backTrack(grid, i, j, used);
      }
    }

    int max = 0;
    for (List<Integer> list : result) {
      max = Math.max(max, list.stream().mapToInt(i -> i).sum());
    }
    return max;
  }

  public void backTrack(int[][] grid, int row, int col, boolean[][] used) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return;
    }
    if (grid[row][col] == 0 || used[row][col]) {
      return;
    }
    if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
      result.add(new ArrayList<>(deque));
      return;
    }

    used[row][col] = true;
    deque.push(grid[row][col]);
    // 每个格子上下左右4个选择
    backTrack(grid, row - 1, col, used);
    used[row][col] = false;
    deque.pop();

    backTrack(grid, row + 1, col, used);
    used[row][col] = false;
    deque.pop();

    backTrack(grid, row, col - 1, used);
    used[row][col] = false;
    deque.pop();

    backTrack(grid, row, col + 1, used);
    used[row][col] = false;
    deque.pop();
  }
}
