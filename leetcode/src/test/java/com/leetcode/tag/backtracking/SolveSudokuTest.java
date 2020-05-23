package com.leetcode.tag.backtracking;

import org.junit.Test;

public class SolveSudokuTest {
  @Test
  public void replaceSpaceTest() {
    SolveSudoku solveSudoku = new SolveSudoku();
    String[][] board =
            new String[][]{
                    {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                    {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                    {".", "9", "8", ".", ".", ".", ".", "6", "."},
                    {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                    {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                    {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                    {".", "6", ".", ".", ".", ".", "2", "8", "."},
                    {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                    {".", ".", ".", ".", "8", ".", ".", "7", "9"}
            };

    char[][] chars = new char[board.length][board.length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        chars[i][j] = board[i][j].charAt(0);
      }
    }

    solveSudoku.solveSudoku(chars);
  }
}
