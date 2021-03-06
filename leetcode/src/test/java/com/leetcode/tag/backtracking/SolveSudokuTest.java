package com.leetcode.tag.backtracking;

import com.leetcode.tag.backtracking.one.SolveSudoku;
import org.junit.Test;

public class SolveSudokuTest {
  @Test
  public void replaceSpaceTest() {
    SolveSudoku.Solution solveSudoku = new SolveSudoku.Solution();
    char[][] board =
            new char[][]{
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };

    solveSudoku.solveSudoku(board);

    System.out.println();
  }
}
