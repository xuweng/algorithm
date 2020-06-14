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

  /**
   * 思路差不多
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/unique-paths-iii/solution/bu-tong-lu-jing-iii-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    int ans;
    int[][] grid;
    int tr, tc;
    // 行和列一一对应。
    // 行。上下左右。
    int[] dr = new int[]{0, -1, 0, 1};
    // 列。上下左右。
    int[] dc = new int[]{1, 0, -1, 0};
    int R, C;

    public int uniquePathsIII(int[][] grid) {
      this.grid = grid;
      R = grid.length;
      C = grid[0].length;

      int todo = 0;
      int sr = 0, sc = 0;
      for (int r = 0; r < R; ++r) {
        for (int c = 0; c < C; ++c) {
          if (grid[r][c] != -1) {
            todo++;
          }

          if (grid[r][c] == 1) {
            sr = r;
            sc = c;
          } else if (grid[r][c] == 2) {
            tr = r;
            tc = c;
          }
        }
      }

      ans = 0;
      dfs(sr, sc, todo);
      return ans;
    }

    public void dfs(int r, int c, int todo) {
      todo--;
      if (todo < 0) {
        return;
      }
      if (r == tr && c == tc) {
        if (todo == 0) {
          ans++;
        }
        return;
      }

      grid[r][c] = 3;
      for (int k = 0; k < 4; ++k) {
        int nr = r + dr[k];
        int nc = c + dc[k];
        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
          if (grid[nr][nc] % 2 == 0) {
            dfs(nr, nc, todo);
          }
        }
      }
      grid[r][c] = 0;
    }
  }
}
