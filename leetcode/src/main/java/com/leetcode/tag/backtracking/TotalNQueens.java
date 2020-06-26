package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  private List<Character[][]> result;
  private int n;

  public int totalNQueens(int n) {
    // 初始化
    left = new boolean[n + n];
    right = new boolean[n + n];
    horizontal = new boolean[n];
    vertical = new boolean[n];
    this.n = n;
    result = new ArrayList<>();

    Character[][] chars = new Character[n][n];
    for (Character[] c : chars) {
      Arrays.fill(c, '.');
    }

    backTrack(chars, 0);

    return result.size();
  }

  public void backTrack(Character[][] chars, int row) {
    if (row >= chars.length) {
      result.add(chars);
      return;
    }
    for (int i = 0; i < chars[0].length; i++) {
      if (!check(row, i)) {
        continue;
      }
      // 一一对应
      chars[row][i] = 'Q';
      set(row, i, true);
      // 搜索所有答案.不是搜索到一个答案就返回。
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
