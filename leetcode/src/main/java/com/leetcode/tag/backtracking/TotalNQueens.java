package com.leetcode.tag.backtracking;

/**
 * 不要纠结。没时间纠结。没时间纠结。没时间纠结
 *
 * <p>没时间纠结。没时间纠结。没时间纠结。没时间纠结
 *
 * <p>没时间纠结。没时间纠结。没时间纠结。没时间纠结
 *
 * <p>不要纠结
 *
 * <p>不要纠结。不要纠结。不要纠结。不要纠结
 *
 * <p>不要纠结。不要纠结。不要纠结。不要纠结
 *
 * <p>52. N皇后 II
 */
public class TotalNQueens {
  // 左斜
  private boolean[] left;
  // 右斜
  private boolean[] right;
  // 横
  private boolean[] horizontal;
  // 竖
  private boolean[] vertical;
  private int n;

  public int totalNQueens(int n) {
    return 0;
  }

  public void backTrack(char[][] chars, int row) {
    for (int i = 0; i < chars[0].length; i++) {
      if (!check(row, i)) {
        continue;
      }
      // 一一对应
      chars[row][i] = 'Q';
      set(row, i, true);
      backTrack(chars, row + 1);
      // 回溯。和上面一一对应。
      chars[row][i] = '.';
      set(row, i, false);
    }
  }

  private void set(int row, int col, boolean value) {
    horizontal[row] = value;
    vertical[col] = value;
    left[row + col] = value;
    right[n - row + col] = value;
  }

  private boolean check(int row, int col) {
    return !horizontal[row] && !vertical[col] && !left[row + col] && !right[n - row + col];
  }
}
